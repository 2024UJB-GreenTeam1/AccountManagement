package Mains1;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MapApp extends JFrame {

    private static final String API_KEY = "a9d43df98fad0a7786a2d9199c131b59"; // Kakao Developers에서 발급받은 REST API 키

    public MapApp() {
        setTitle("Kakao Map GUI");
        setSize(600, 170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creating logo button
        JButton logo = new JButton(new ImageIcon("C:\\Users\\Manic-063\\git\\AccountManagement\\bin\\img\\logo_Map.jpg"));
        logo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        logo.setBounds(10, 5, 70, 70);

        // Fonts
        Font font1 = new Font("맑은 고딕", Font.BOLD, 15);
        Font font2 = new Font("맑은 고딕", Font.BOLD, 13);

      
        JTextField addressField = new JTextField(20);
        addressField.setFont(font2);
        JButton searchButton = new JButton("검색");
        searchButton.setFont(font1);
        searchButton.addActionListener(e -> {
            String address = addressField.getText();
            try {
                String apiUrl = "https://dapi.kakao.com/v2/local/search/keyword.json?query=" +
                        URLEncoder.encode(address, StandardCharsets.UTF_8);
                String jsonString = sendGetRequest(apiUrl, API_KEY);
                String x = extractCoordinate(jsonString, "x");
                String y = extractCoordinate(jsonString, "y");
                String mapUrl = "https://map.kakao.com/?q=" + y + "," + x;
                Desktop.getDesktop().browse(new URL(mapUrl).toURI());
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

     
        JPanel panel = new JPanel(null);
        panel.add(logo);
        panel.add(new JLabel("주소를 입력해주세요"));
        panel.add(addressField);
        panel.add(searchButton);

       
        addressField.setBounds(180, 80, 280, 25);
        searchButton.setBounds(490, 75, 70, 30);
        JLabel searchLabel = new JLabel("주소를 입력해주세요");
        searchLabel.setFont(font1);
        searchLabel.setBounds(15, 70, 190, 40);
        panel.add(searchLabel);

        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MapApp();
    }

    private static String sendGetRequest(String apiUrl, String apiKey) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "KakaoAK " + apiKey);
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            return response.toString();
        } else {
            throw new IOException(responseCode + " 예시처럼 입력해주세요. 예시)경기도 의정부시 가능동 헬스장 ");
        }
    }

    private static String extractCoordinate(String jsonString, String key) {
        int index = jsonString.indexOf("\"" + key + "\":\"");
        if (index != -1) {
            int startIndex = index + key.length() + 4;
            int endIndex = jsonString.indexOf("\"", startIndex);
            return jsonString.substring(startIndex, endIndex);
        }
        return null;
    }
}
