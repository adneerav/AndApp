package com.example.hb.andapp;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * Created by hb on 10/1/2015.
 */
public class WSGsonTest<T> extends Request<T> {
    private Class<T> mClass;
    private Response.Listener<T> responseListner;
    private final Gson gson = new Gson();

    /**
     * Creates a new request with the given method (one of the values from {@link Method}),
     * URL, and error listener.  Note that the normal response listener is not provided here as
     * delivery of responses is provided by subclasses, who have a better idea of how to deliver
     * an already-parsed response.
     *
     * @param method
     * @param url
     * @param listener
     */
    public WSGsonTest(int method, String url, Class<T> mClass, Response.Listener<T> responseListner, Response.ErrorListener listener) {
        super(method, url, listener);
        this.mClass = mClass;
        this.responseListner = responseListner;
    }

    /**
     * Subclasses must implement this to parse the raw network response
     * and return an appropriate response type. This method will be
     * called from a worker thread.  The response will not be delivered
     * if you return null.
     *
     * @param response Response from the network
     * @return The parsed response, or null in the case of an error
     */
    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String str = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            List<T> a = new ResponseTest().getListingData(str, mClass);
            return Response.success(gson.fromJson(str, mClass), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
        }
        return null;
    }

    /**
     * Returns a list of extra HTTP headers to go along with this request. Can
     * throw {@link AuthFailureError} as authentication may be required to
     * provide these values.
     *
     * @throws AuthFailureError In the event of auth failure
     */
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return super.getHeaders();
    }

    /**
     * Subclasses must implement this to perform delivery of the parsed
     * response to their listeners.  The given response is guaranteed to
     * be non-null; responses that fail to parse are not delivered.
     *
     * @param response The parsed response returned by
     *                 {@link #parseNetworkResponse(NetworkResponse)}
     */
    @Override
    protected void deliverResponse(T response) {
        responseListner.onResponse(response);
    }
}
