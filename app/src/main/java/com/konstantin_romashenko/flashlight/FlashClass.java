package com.konstantin_romashenko.flashlight;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;

public class FlashClass
{
    private boolean flash_status = false;
    private Context context;
    public FlashClass(Context context)
    {
        this.context = context;
    }

    public void flashOn() {
        CameraManager cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        try{
            assert cameraManager != null;

            String camera_id = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(camera_id, true);
            flash_status = true;
        }
        catch(CameraAccessException exc)
        {
            exc.printStackTrace();
        }


    }

    public void flashOff()
    {
        CameraManager cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        try{
            assert cameraManager != null;

            String camera_id = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(camera_id, false);
            flash_status = false;
        }
        catch(CameraAccessException exc)
        {
            exc.printStackTrace();
        }
    }

    public boolean isFlash_status()
    {
        return flash_status;
    }


}
