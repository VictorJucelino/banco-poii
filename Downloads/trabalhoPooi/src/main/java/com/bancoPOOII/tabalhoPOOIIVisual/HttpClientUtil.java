package com.bancoPOOII.tabalhoPOOIIVisual;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class HttpClientUtil {

    // URL base da API (centralizada)
    private static final String BASE_URL = "http://localhost:8080";

    // Método POST para criar uma conta
    public static void postRequest(String endpoint, String jsonInputString) throws IOException {
        URL obj = new URL(BASE_URL + endpoint);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        // Enviar os dados JSON para o servidor
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int responseCode = con.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_CREATED) {
            throw new IOException("Erro na requisição POST: " + responseCode);
        }
    }

    // Método PUT para atualizar uma conta
    public static void putRequest(String endpoint, String jsonInputString) throws IOException {
        URL obj = new URL(BASE_URL + endpoint);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        // Enviar os dados JSON para o servidor
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int responseCode = con.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("Erro na requisição PUT: " + responseCode);
        }
    }

    // Método DELETE para apagar uma conta
    public static void deleteRequest(String endpoint) throws IOException {
        URL obj = new URL(BASE_URL + endpoint);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("DELETE");

        int responseCode = con.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_NO_CONTENT) {
            throw new IOException("Erro na requisição DELETE: " + responseCode);
        }
    }

    // Método GET para buscar dados
    public static String getRequest(String endpoint) throws IOException {
        URL obj = new URL(BASE_URL + endpoint);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");

        // Ler a resposta do servidor
        int responseCode = con.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("Erro na requisição GET: " + responseCode);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}
