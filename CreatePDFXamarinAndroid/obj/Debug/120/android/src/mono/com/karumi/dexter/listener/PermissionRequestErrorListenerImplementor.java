package mono.com.karumi.dexter.listener;


public class PermissionRequestErrorListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.karumi.dexter.listener.PermissionRequestErrorListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onError:(Lcom/karumi/dexter/listener/DexterError;)V:GetOnError_Lcom_karumi_dexter_listener_DexterError_Handler:Com.Karumi.Dexter.Listener.IPermissionRequestErrorListenerInvoker, EDMTBinding\n" +
			"";
		mono.android.Runtime.register ("Com.Karumi.Dexter.Listener.IPermissionRequestErrorListenerImplementor, EDMTBinding", PermissionRequestErrorListenerImplementor.class, __md_methods);
	}


	public PermissionRequestErrorListenerImplementor ()
	{
		super ();
		if (getClass () == PermissionRequestErrorListenerImplementor.class)
			mono.android.TypeManager.Activate ("Com.Karumi.Dexter.Listener.IPermissionRequestErrorListenerImplementor, EDMTBinding", "", this, new java.lang.Object[] {  });
	}


	public void onError (com.karumi.dexter.listener.DexterError p0)
	{
		n_onError (p0);
	}

	private native void n_onError (com.karumi.dexter.listener.DexterError p0);

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
