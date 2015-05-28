package com.kd.lockscreen;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MyLock extends Activity{
	private DevicePolicyManager policyManager;
	private ComponentName componentName;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //��ȡ�豸�������
        policyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
        
        //AdminReceiver �̳��� DeviceAdminReceiver
        componentName = new ComponentName(this, AdminReceiver.class);
        
    	boolean active = policyManager.isAdminActive(componentName);
    	
    	if(!active){//����Ȩ��
            // �����豸����(��ʽIntent) - ��AndroidManifest.xml���趨��Ӧ������
            Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            
            //Ȩ���б�
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);

            //����(additional explanation)
            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "------ ���� ------");

            startActivityForResult(intent, 0);
    			
    		policyManager.lockNow();//������ 
    	
    	}else{
        	
            policyManager.lockNow();//ֱ������
        }
    	finish();
 
    //  killMyself ������֮�������kill�����ǵ�Activity��������Դ���˷�;   
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
