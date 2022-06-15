package mono.com.karumi.dexter;


public class DexterBuilder_SinglePermissionListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.karumi.dexter.DexterBuilder.SinglePermissionListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_withListener:(Lcom/karumi/dexter/listener/single/PermissionListener;)Lcom/karumi/dexter/DexterBuilder;:GetWithListener_Lcom_karumi_dexter_listener_single_PermissionListener_Handler:Com.Karumi.Dexter.IDexterBuilderSinglePermissionListenerInvoker, EDMTBinding\n" +
			"";
		mono.android.Runtime.register ("Com.Karumi.Dexter.IDexterBuilderSinglePermissionListenerImplementor, EDMTBinding", DexterBuilder_SinglePermissionListenerImplementor.class, __md_methods);
	}


	public DexterBuilder_SinglePermissionListenerImplementor ()
	{
		super ();
		if (getClass () == DexterBuilder_SinglePermissionListenerImplementor.class)
			mono.android.TypeManager.Activate ("Com.Karumi.Dexter.IDexterBuilderSinglePermissionListenerImplementor, EDMTBinding", "", this, new java.lang.Object[] {  });
	}


	public com.karumi.dexter.DexterBuilder withListener (com.karumi.dexter.listener.single.PermissionListener p0)
	{
		return n_withListener (p0);
	}

	private native com.karumi.dexter.DexterBuilder n_withListener (com.karumi.dexter.listener.single.PermissionListener p0);

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
