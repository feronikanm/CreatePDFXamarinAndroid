package mono.com.karumi.dexter;


public class DexterBuilder_MultiPermissionListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.karumi.dexter.DexterBuilder.MultiPermissionListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_withListener:(Lcom/karumi/dexter/listener/multi/MultiplePermissionsListener;)Lcom/karumi/dexter/DexterBuilder;:GetWithListener_Lcom_karumi_dexter_listener_multi_MultiplePermissionsListener_Handler:Com.Karumi.Dexter.IDexterBuilderMultiPermissionListenerInvoker, EDMTBinding\n" +
			"";
		mono.android.Runtime.register ("Com.Karumi.Dexter.IDexterBuilderMultiPermissionListenerImplementor, EDMTBinding", DexterBuilder_MultiPermissionListenerImplementor.class, __md_methods);
	}


	public DexterBuilder_MultiPermissionListenerImplementor ()
	{
		super ();
		if (getClass () == DexterBuilder_MultiPermissionListenerImplementor.class)
			mono.android.TypeManager.Activate ("Com.Karumi.Dexter.IDexterBuilderMultiPermissionListenerImplementor, EDMTBinding", "", this, new java.lang.Object[] {  });
	}


	public com.karumi.dexter.DexterBuilder withListener (com.karumi.dexter.listener.multi.MultiplePermissionsListener p0)
	{
		return n_withListener (p0);
	}

	private native com.karumi.dexter.DexterBuilder n_withListener (com.karumi.dexter.listener.multi.MultiplePermissionsListener p0);

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
