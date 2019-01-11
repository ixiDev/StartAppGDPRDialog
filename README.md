# StartAppGDPRDialog

[![](https://www.jitpack.io/v/ixiDev/StartAppGDPRDialog.svg)](https://www.jitpack.io/#ixiDev/StartAppGDPRDialog)

### How to
Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.ixiDev:StartAppGDPRDialog:1.0'
	}


###
How to use


Make your MainActivity implement the GDPRCallback

public class MainActivity extends AppCompatActivity implements GDPRCallback 
  
  
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        new GDPRDialog(this)
                .create(this, new Runnable() {
                    @Override
                    public void run() {
                        // TODO: 11/01/2019 nothing todo here
                    }
                });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    
    
    
    
     @Override
    public void onInitStartAppSdk() {
        StartAppSDK.init(MainActivity.this,
                START_APP_ID, false);
        StartAppAd.disableSplash(); // disable splash ad
        StartAppAd.disableAutoInterstitial(); // disable auto ads

    }

    @Override
    public void onPersonalizedAdsConsentChange(boolean isGranted) {
        StartAppSDK.setUserConsent(this, "pas",
                System.currentTimeMillis(), isGranted);
    }
