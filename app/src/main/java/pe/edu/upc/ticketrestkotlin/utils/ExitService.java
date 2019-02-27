package pe.edu.upc.ticketrestkotlin.utils;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class ExitService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        Log.v("ProcessLog","App Closed");
        Toast.makeText(this,"App Closed",Toast.LENGTH_LONG).show();
        this.stopSelf();
    }
}
