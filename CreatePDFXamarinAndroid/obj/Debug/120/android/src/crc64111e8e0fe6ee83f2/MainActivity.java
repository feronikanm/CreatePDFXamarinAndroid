package crc64111e8e0fe6ee83f2;


public class MainActivity
	extends androidx.appcompat.app.AppCompatActivity
	implements
		mono.android.IGCUserPeer,
		com.karumi.dexter.listener.single.PermissionListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\n" +
			"n_onRequestPermissionsResult:(I[Ljava/lang/String;[I)V:GetOnRequestPermissionsResult_IarrayLjava_lang_String_arrayIHandler\n" +
			"n_onPermissionDenied:(Lcom/karumi/dexter/listener/PermissionDeniedResponse;)V:GetOnPermissionDenied_Lcom_karumi_dexter_listener_PermissionDeniedResponse_Handler:Com.Karumi.Dexter.Listener.Single.IPermissionListenerInvoker, EDMTBinding\n" +
			"n_onPermissionGranted:(Lcom/karumi/dexter/listener/PermissionGrantedResponse;)V:GetOnPermissionGranted_Lcom_karumi_dexter_listener_PermissionGrantedResponse_Handler:Com.Karumi.Dexter.Listener.Single.IPermissionListenerInvoker, EDMTBinding\n" +
			"n_onPermissionRationaleShouldBeShown:(Lcom/karumi/dexter/listener/PermissionRequest;Lcom/karumi/dexter/PermissionToken;)V:GetOnPermissionRationaleShouldBeShown_Lcom_karumi_dexter_listener_PermissionRequest_Lcom_karumi_dexter_PermissionToken_Handler:Com.Karumi.Dexter.Listener.Single.IPermissionListenerInvoker, EDMTBinding\n" +
			"";
		mono.android.Runtime.register ("CreatePDFXamarinAndroid.MainActivity, CreatePDFXamarinAndroid", MainActivity.class, __md_methods);
	}


	public MainActivity ()
	{
		super ();
		if (getClass () == MainActivity.class)
			mono.android.TypeManager.Activate ("CreatePDFXamarinAndroid.MainActivity, CreatePDFXamarinAndroid", "", this, new java.lang.Object[] {  });
	}


	public MainActivity (int p0)
	{
		super (p0);
		if (getClass () == MainActivity.class)
			mono.android.TypeManager.Activate ("CreatePDFXamarinAndroid.MainActivity, CreatePDFXamarinAndroid", "System.Int32, mscorlib", this, new java.lang.Object[] { p0 });
	}


	public void onCreate (android.os.Bundle p0)
	{
		n_onCreate (p0);
	}

	private native void n_onCreate (android.os.Bundle p0);


	public void onRequestPermissionsResult (int p0, java.lang.String[] p1, int[] p2)
	{
		n_onRequestPermissionsResult (p0, p1, p2);
	}

	private native void n_onRequestPermissionsResult (int p0, java.lang.String[] p1, int[] p2);


	public void onPermissionDenied (com.karumi.dexter.listener.PermissionDeniedResponse p0)
	{
		n_onPermissionDenied (p0);
	}

	private native void n_onPermissionDenied (com.karumi.dexter.listener.PermissionDeniedResponse p0);


	public void onPermissionGranted (com.karumi.dexter.listener.PermissionGrantedResponse p0)
	{
		n_onPermissionGranted (p0);
	}

	private native void n_onPermissionGranted (com.karumi.dexter.listener.PermissionGrantedResponse p0);


	public void onPermissionRationaleShouldBeShown (com.karumi.dexter.listener.PermissionRequest p0, com.karumi.dexter.PermissionToken p1)
	{
		n_onPermissionRationaleShouldBeShown (p0, p1);
	}

	private native void n_onPermissionRationaleShouldBeShown (com.karumi.dexter.listener.PermissionRequest p0, com.karumi.dexter.PermissionToken p1);

	private java.util.ArrayList refList;
	public void monodroidAddReference (java.lang.Object obj)
	{
		if (refList == null)
			refList = new java.util.ArrayList ();
		refList.add (obj);
	}

	public void monodroidClearReferences ()
	{
		if (refList != null)
			refList.clear ();
	}
}
