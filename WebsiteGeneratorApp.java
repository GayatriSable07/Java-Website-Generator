import javax.swing.*;
import java.awt.*;
import java.io.*;

public class WebsiteGeneratorApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Website Generator");
        frame.setSize(500, 480);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setBackground(new Color(167, 199, 231));

        JLabel l1 = new JLabel("Website Type:");
        l1.setBounds(20, 20, 120, 25);

        String[] types = {"Restaurant", "Portfolio", "Business"};
        JComboBox<String> box = new JComboBox<>(types);
        box.setBounds(160, 20, 250, 25);

        JLabel l2 = new JLabel("Name:");
        l2.setBounds(20, 60, 120, 25);

        JTextField nameField = new JTextField();
        nameField.setBounds(160, 60, 250, 25);

        JLabel l3 = new JLabel("Details:");
        l3.setBounds(20, 100, 120, 25);

        JTextArea details = new JTextArea();
        details.setBounds(160, 100, 250, 80);

        JButton btn = new JButton("Generate Website");
        btn.setBounds(150, 210, 180, 35);

        JLabel status = new JLabel("");
        status.setBounds(20, 260, 430, 25);

        btn.addActionListener(e -> {

            try {

                String type = box.getSelectedItem().toString();
                String name = nameField.getText();
                String info = details.getText();

                String html = "";

                // Restaurant Website
                if (type.equals("Restaurant")) {

                    html =
                            "<html><head><title>" + name + "</title></head>" +
                            "<body style='font-family:Arial;background:#fff3e0;padding:20px;'>" +
                            "<div style='background:white;padding:20px;border-radius:15px;'>" +
                            "<h1 style='text-align:center;color:#c0392b;'>" + name + "</h1>" +
                            "<img src='food.jpg' width='300'>" +
                            "<h2>About Us</h2><p>" + info + "</p>" +
                            "<h2>Menu</h2>" +
                            "<table border='1' cellpadding='10'>" +
                            "<tr><th>Dish</th><th>Price</th></tr>" +
                            "<tr><td>Paneer Butter Masala</td><td>220</td></tr>" +
                            "<tr><td>Veg Biryani</td><td>180</td></tr>" +
                            "<tr><td>Butter Naan</td><td>40</td></tr>" +
                            "</table>" +
                            "<h2>Address</h2><p>Pune, India</p>" +
                            "</div></body></html>";
                }

                // Portfolio Website
                else if (type.equals("Portfolio")) {

                    html =
                            "<html><head><title>" + name + "</title></head>" +
                            "<body style='font-family:Arial;background:#e3f2fd;padding:20px;'>" +
                            "<div style='background:white;padding:20px;border-radius:15px;'>" +
                            "<h1>" + name + "</h1>" +
                            "<img src='profile.jpg' width='300'>" +
                            "<p>" + info + "</p>" +
                            "<h2>Skills</h2>" +
                            "<ul>" +
                            "<li>Java</li>" +
                            "<li>Web Development</li>" +
                            "<li>Artificial Intelligence</li>" +
                            "</ul>" +
                            "<h2>Contact</h2>" +
                            "<p>Email: example@gmail.com</p>" +
                            "</div></body></html>";
                }

                // Business Website
                else {

                    html =
                            "<html><head><title>" + name + "</title></head>" +
                            "<body style='font-family:Arial;background:#e8f5e9;padding:20px;'>" +
                            "<div style='background:white;padding:20px;border-radius:15px;'>" +
                            "<h1>" + name + "</h1>" +
                            "<img src='profile.jpg' width='300'>" +
                            "<p>" + info + "</p>" +
                            "<h2>Services</h2>" +
                            "<ul>" +
                            "<li>Consulting</li>" +
                            "<li>Software Development</li>" +
                            "<li>Technical Support</li>" +
                            "</ul>" +
                            "<h2>Contact</h2>" +
                            "<p>Phone: 9XXXXXXXXX</p>" +
                            "</div></body></html>";
                }

                FileWriter fw = new FileWriter("index.html");
                fw.write(html);
                fw.close();

                Desktop.getDesktop().browse(new File("index.html").toURI());

                status.setText("Website created successfully!");

            } catch (Exception ex) {

                status.setText("Error creating website.");
            }
        });

        frame.add(l1);
        frame.add(box);

        frame.add(l2);
        frame.add(nameField);

        frame.add(l3);
        frame.add(details);

        frame.add(btn);
        frame.add(status);

        frame.setVisible(true);
    }
}
