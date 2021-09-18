package gg.codie.minecraft;

import gg.codie.spritecaster.SpriteCasterFiles;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipFile;

public class MinecraftVersionsService {
    public ZipFile getLatestVersion() throws IOException {
        try {
            URL versionManifestURL = new URL("https://launchermeta.mojang.com/mc/game/version_manifest_v2.json");
            HttpURLConnection connection;
            connection = (HttpURLConnection) versionManifestURL.openConnection();
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(false);

            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();

            JSONObject version_manifest = new JSONObject(response.toString());

            String latestRelease = version_manifest.getJSONObject("latest").getString("release");

            File existingClient = new File(SpriteCasterFiles.MINECRAFT_VERSIONS_PATH + latestRelease + File.separator + latestRelease + ".jar");
            if (existingClient.exists()) {
                return new ZipFile(existingClient);
            }

            URL latestJsonURL = null;
            for (Object version : version_manifest.getJSONArray("versions")) {
                if (((JSONObject) version).optString("id").equals(latestRelease)) {
                    latestJsonURL = new URL(((JSONObject) version).getString("url"));
                }
            }

            connection = (HttpURLConnection) latestJsonURL.openConnection();
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(false);

            is = connection.getInputStream();
            rd = new BufferedReader(new InputStreamReader(is));

            response = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();

            JSONObject version_json = new JSONObject(response.toString());
            URL jarUrl = new URL(version_json.getJSONObject("downloads").getJSONObject("client").getString("url"));

            connection = (java.net.HttpURLConnection) (jarUrl.openConnection());
            InputStream in = connection.getInputStream();

            String path = SpriteCasterFiles.SPRITECASTER_FOLDER + "minecraft.jar";

            File clientJar = new File(path);
            clientJar.getParentFile().mkdirs();
            OutputStream out = new java.io.FileOutputStream(path, false);

            final byte[] data = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                out.write(data, 0, count);
            }

            return new ZipFile(clientJar);
        } catch (Exception ex) {
            File cachedClient = new File(SpriteCasterFiles.SPRITECASTER_FOLDER + "minecraft.jar");
            if (cachedClient.exists())
                return new ZipFile(cachedClient);
            else
                throw new FileNotFoundException("no minecraft jar");
        }
    }
}
