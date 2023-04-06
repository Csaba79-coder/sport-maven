package org.csaba79coder.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class FootballController {

    private final String apiKey;

    public FootballController() {
        this.apiKey = System.getenv("SPORTMONKS_API_KEY");
    }

    public Object renderAllFootballTeams() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClients.createDefault();
        URIBuilder builder = new URIBuilder("https://api.sportmonks.com/v3/football/teams");
        URI uri = builder.build();
        HttpGet httpGet = new HttpGet(uri);
        httpGet.setHeader(HttpHeaders.AUTHORIZATION, apiKey);
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity, ContentType.APPLICATION_JSON.getCharset());
    }
}
