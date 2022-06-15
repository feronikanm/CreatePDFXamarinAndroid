using Android;
using Android.App;
using Android.Content;
using Android.OS;
using Android.Print;
using Android.Runtime;
using Android.Util;
using Android.Widget;
using AndroidX.AppCompat.App;
using Com.Karumi.Dexter;
using Com.Karumi.Dexter.Listener;
using Com.Karumi.Dexter.Listener.Single;
using CreatePDFXamarinAndroid.Common;
using iTextSharp.text;
using iTextSharp.text.pdf;
using iTextSharp.text.pdf.draw;
using System;
using System.IO;

namespace CreatePDFXamarinAndroid
{
    [Activity(Label = "@string/app_name", Theme = "@style/AppTheme", MainLauncher = true)]
    public class MainActivity : AppCompatActivity, IPermissionListener
    {
        Button btn_create_pdf;
        public static string fileName = "Order.Pdf";

        protected override async void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            Xamarin.Essentials.Platform.Init(this, savedInstanceState);
            // Set our view from the "main" layout resource
            SetContentView(Resource.Layout.activity_main);

            btn_create_pdf = FindViewById<Button>(Resource.Id.btn_create_pdf);

            await Common.Common.WriteFileToStorageAsync(this, "roboto.ttf");
            Dexter.WithActivity(this)
                .WithPermission(Manifest.Permission.WriteExternalStorage)
                .WithListener(this)
                .Check();

        }
        public override void OnRequestPermissionsResult(int requestCode, string[] permissions, [GeneratedEnum] Android.Content.PM.Permission[] grantResults)
        {
            Xamarin.Essentials.Platform.OnRequestPermissionsResult(requestCode, permissions, grantResults);

            base.OnRequestPermissionsResult(requestCode, permissions, grantResults);
        }

        public void OnPermissionDenied(PermissionDeniedResponse p0)
        {
            Toast.MakeText(this, "You must accept this permission", ToastLength.Short).Show();
        }

        public void OnPermissionGranted(PermissionGrantedResponse p0)
        {
            btn_create_pdf.Click += delegate
            {
                CreatePDFFile(Common.Common.GetAppPath(this) + fileName);
            };
        }

        private void CreatePDFFile(string v)
        {
            //check Available
            if(new Java.IO.File(v).Exists())
                new Java.IO.File(v).Delete(); 
            try
            {
                Document document = new Document();
                //save
                PdfWriter.GetInstance(document, new FileStream(v, FileMode.Create));
                //open
                document.Open();
                //settings
                document.SetPageSize(PageSize.A4);
                document.AddCreationDate();
                document.AddAuthor("author");
                document.AddCreator("author");

                //font setting
                Color colorAccent = new Color(0, 153, 204, 255);
                float fontSize = 20.0f, valueFontSize = 26.0f;
                BaseFont fontName = BaseFont.CreateFont(Common.Common.GetFilePath(this, "roboto.ttf"),
                    "UTF-8",
                    BaseFont.EMBEDDED);

                //create title of document
                Font titleFont = new Font(fontName, 36.0f, Font.NORMAL, Color.BLACK);
                addNewItem(document, "Order Deatils", Element.ALIGN_CENTER, titleFont);

                // Add more
                Font orderNumberFont = new Font(fontName, fontSize, Font.NORMAL, colorAccent);
                addNewItem(document, "Order No:", Element.ALIGN_LEFT, orderNumberFont);

                Font orderNumberValueFont = new Font(fontName, valueFontSize, Font.NORMAL, Color.BLACK);
                addNewItem(document, "#717171", Element.ALIGN_LEFT, orderNumberValueFont);

                addLineSeperator(document);

                addNewItem(document, "Order Date", Element.ALIGN_LEFT, orderNumberFont);
                addNewItem(document, "15/06/2022", Element.ALIGN_LEFT, orderNumberValueFont);

                addLineSeperator(document);

                addNewItem(document, "Account name", Element.ALIGN_LEFT, orderNumberFont);
                addNewItem(document, "Fero", Element.ALIGN_LEFT, orderNumberValueFont);

                addLineSeperator(document);

                //Add product order detail
                AddLineSpace(document);
                addNewItem(document, "Product details", Element.ALIGN_CENTER, titleFont);

                addLineSeperator(document);

                //item 1
                AddNewItemWithLeftAndRight(document, "Burger", "(1.0%)", titleFont, orderNumberValueFont);
                AddNewItemWithLeftAndRight(document, "20", "1200.0", titleFont, orderNumberValueFont);

                addLineSeperator(document);

                //item 2
                AddNewItemWithLeftAndRight(document, "Pizza", "(0.0%)", titleFont, orderNumberValueFont);
                AddNewItemWithLeftAndRight(document, "12", "1520.0", titleFont, orderNumberValueFont);

                addLineSeperator(document);

                //item 3
                AddNewItemWithLeftAndRight(document, "Sandwich", "(0.0%)", titleFont, orderNumberValueFont);
                AddNewItemWithLeftAndRight(document, "10", "1000.0", titleFont, orderNumberValueFont);

                addLineSeperator(document);

                //Total
                AddLineSpace(document);
                AddLineSpace(document);

                AddNewItemWithLeftAndRight(document, "total", "8500", titleFont, orderNumberValueFont);

                document.Close();
                Toast.MakeText(this, "Sucess create PDF", ToastLength.Short).Show();

                PrintPDF();

            }
            catch(FileNotFoundException e)
            {
                Log.Debug("", "" + e.Message);
            }
            catch (DocumentException e)
            {
                Log.Debug("", "" + e.Message);
            }
            catch (IOException e)
            {
                Log.Debug("", "" + e.Message);
            }
        }

        private void PrintPDF()
        {
            PrintManager printManager = (PrintManager)GetSystemService(Context.PrintService);
            try
            {
                PrintDocumentAdapter adapter = new PrintPDFAdapter(this, Common.Common.GetAppPath(this) + fileName);
                printManager.Print("Document", adapter, new PrintAttributes.Builder().Build());
            }
            catch (Exception e)
            {
                Log.Error("Author", "" + e.Message);
            }
        }

        private void AddNewItemWithLeftAndRight(Document document, string leftText, string rightText, Font leftFont, Font rightFont)
        {
            Chunk chunkTextLeft = new Chunk(leftText, leftFont);
            Chunk chunkTextRight = new Chunk(rightText, rightFont);
            Paragraph p = new Paragraph(chunkTextLeft);
            p.Add(new Chunk(new VerticalPositionMark()));
            p.Add(chunkTextRight);
            document.Add(p);
        }

        private void addLineSeperator(Document document)
        {
            LineSeparator lineSeparator = new LineSeparator();
            lineSeparator.LineColor = new Color(0, 0, 0, 68);
            AddLineSpace(document);
            document.Add(new Chunk(lineSeparator));
            AddLineSpace(document);
        }

        private void AddLineSpace(Document document)
        {
            document.Add(new Paragraph(""));
        }

        private void addNewItem(Document document, string text, int align, Font font)
        {
            Chunk chunk = new Chunk(text, font);
            Paragraph paragraph = new Paragraph(chunk);
            paragraph.Alignment = align;
            document.Add(paragraph);
        }

        public void OnPermissionRationaleShouldBeShown(PermissionRequest p0, IPermissionToken p1)
        {
            throw new System.NotImplementedException();
        }
    }
}