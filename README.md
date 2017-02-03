# BaseGrizzlynator


## Features
### CrashTracker.java (TEAM 254)
* Surround all the methods in the Robot.java with a try/catch logging exceptions to the file /home/lvuser/crash_tracking.txt

### CrashTrackingRunnable.java (TEAM 254)
* Simple class extending Runnable which will log Exceptions using the CrashTracker

### Looper.java (TEAM 254)
* Using the WPILib's Notifier, Periodically invoke the onLoop() of Registered Loop objects
* Create Disabled Looper and Enabled Looper in the Robot.java
* Start and Stop the looper in the XXXInit() methods of the Robot

### Loop.java (TEAM 254)
* Interface that must be implemented to register in the Looper
* The onStart() and onStop() will be invoked at start and stop of the Looper
* The onLoop() will be periodically invoked until stopped.

