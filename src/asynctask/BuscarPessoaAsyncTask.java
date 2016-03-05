package asynctask;

import java.io.IOException;

import org.json.JSONObject;

import util.HttpService;
import util.Response;
import activity.MainActivity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

public class BuscarPessoaAsyncTask extends AsyncTask<JSONObject, Void, Response> {
	
	private MainActivity mainActivity;
	private ListView nomeslistview;

	public BuscarPessoaAsyncTask(MainActivity mainActivity, ListView nomeslistview) {
		this.mainActivity = mainActivity;
		this.nomeslistview = nomeslistview;
	}

	protected Response doInBackground(JSONObject... jsons) {

        Response response = null;

        JSONObject json = jsons[0];
        Log.i("EditTextListener", "doInBackground (JSON): " + json);

        try {

            response = HttpService.sendJSONPostResquest("get-byname", json);

        } catch (IOException e) {

            Log.e("EditTextListener", e.getMessage());
        }

        return response;
    }

    @Override
    protected void onPostExecute(Response response) {

        Log.i("EditTextListener", "Código HTTP: " + response.getStatusCodeHttp()
                + " Conteúdo: " + response.getContentValue());
    }

}