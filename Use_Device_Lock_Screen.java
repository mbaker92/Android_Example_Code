
/* 	Add the following code to onCreate or any other function where you
	want to call for the System's Lockscreen */

	// Check if device uses a version >= Lollipop
	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

		// Create the Manager
        KeyguardManager km = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);

        // If there is some type of device security (Fingerprint, pin, swipe, etc.)
        if (km.isKeyguardSecure()){

        	// Create the Intent with a Title and Description of why and Start Lockscreen Activity
            Intent authIntent = km.createConfirmDeviceCredentialIntent("Locked","Unlock using System Pin"); // ("Title","Description")
            startActivityForResult(authIntent,241);

        } else{
        	// If there is no security on the device
            Toast.makeText(this, "No Device Security", Toast.LENGTH_SHORT).show();

        }
    }


/* Then add the following function to the Activity */
@Override
protected void onActivityResult(int requestCode,int resultCode,Intent data){
    super.onActivityResult(requestCode,resultCode,data);

    // Entered the right information
    if(resultCode==RESULT_OK && requestCode == 241){

        Toast.makeText(this,"Success",Toast.LENGTH_LONG).show();

    }else{

        Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show();

    }
}