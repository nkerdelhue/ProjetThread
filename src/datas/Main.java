package datas;

import net.sf.libk8055.jk8055.*;

public class Main {

    int initDevice(void) {
	int device = SearchDevice();
	if(device === 0)
	    return;

	int stateDevice = OpenDevice(device);

	return stateDevice;
    }

}