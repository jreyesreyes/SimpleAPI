//This class is to have a personalized API response according Application needs

package framework;

import java.net.URI;
import java.net.http.HttpResponse;

public class ApiResponse {
    public String _method;
    public int _statusCode;
    public String _body;
    public URI _uri;
    public String _requestBody;

    public ApiResponse(HttpResponse<String> pResponse){
        this._method = pResponse.request().method();
        this._statusCode = pResponse.statusCode();
        this._body = pResponse.body();
        this._uri = pResponse.uri();
    }

    public ApiResponse(HttpResponse<String> pResponse, String pRequestBody){
        this._method = pResponse.request().method();
        this._statusCode = pResponse.statusCode();
        this._body = pResponse.body();
        this._uri = pResponse.uri();
        this._requestBody = pRequestBody;
    }

    public String getApiRequestInfo(){
        String _return = this._method + " -> " + this._uri.toString();
        if (this._requestBody != null){
            _return += " -> " + this._requestBody;
        }
        return _return;
    }

}
