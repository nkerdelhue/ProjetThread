public class K8055Test {
    
    public static final int DEVICE = 0;
    
    public static void outputAnalog(int out) throws JK8055Exception {
	JK8055 jk8055 = JK8055.getInstance();
	jk8055.OpenDevice(DEVICE);
	
	try {
	    Thread.sleep(500);
	} catch(Exception e) {}
    }

    public static void writeDigital(int out) throws JK8055Exception  {
	/*	JK8055 jk8055 = JK8055.getInstance();
	jk8055.WriteAllDigital(0);

	jk8055.WriteAllDigital(1 << out);
	try(Thread.sleep(500);}
	catch(Excepton e) {}

	jk8055.WriteAllDigital(0);
	jk8055.CloseDevice(); */

	JK8055 jk8055 = JK8055.getInstance();
	jk8055.WriteAllDigital(0);
	
	jk8055.SetDigitalChannel(out);

	jk8055.CloseDevice();
    }

}