package View;

// import org.jdatepicker.impl.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FormInput extends JFrame {
    // Personal Information Fields
    public JTextField nikField, namaField, tempatLahirField, tanggalLahirPicker, golDarahField, alamatField, rtField,
            rwField, kelDesaField, kecamatanField, pekerjaanField, kewarganegaraanField, wargaNegaraAsalField,
            berlakuHinggaField, kotaPembuatanField, tanggalPembuatanField;
    public JComboBox<String> agamaCombo, statusPerkawinanCombo;
    public JButton fotoButton, tandaTanganButton, submitButton, clearButton;
    // public JDatePickerImpl tanggalLahirPicker;

    // Pekerjaan Checkboxes
    public JCheckBox karyawanSwastaCheckBox, pnsCheckBox, wiraswastaCheckBox, akademisiCheckBox, pengangguranCheckBox;

    public FormInput() {
        setTitle("Form Input KTP");
        setSize(800, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(30, 5, 5, 5));

        // Personal Information Input Fields
        add(new JLabel("NIK:"));
        nikField = new JTextField();
        add(nikField);

        add(new JLabel("Nama:"));
        namaField = new JTextField();
        add(namaField);

        add(new JLabel("Tempat Lahir:"));
        tempatLahirField = new JTextField();
        add(tempatLahirField);

        add(new JLabel("Tanggal Lahir:"));
        tanggalLahirPicker = new JTextField();
        add(tanggalLahirPicker);
        // add(new JLabel("Tanggal Lahir:"));
        // tanggalLahirPicker = createDatePicker();
        // add(tanggalLahirPicker);

        // Jenis Kelamin Radio Buttons
        JRadioButton lakiLakiRadioButton = new JRadioButton("PRIA");
        JRadioButton perempuanRadioButton = new JRadioButton("WANITA");
        ButtonGroup kelompokJenisKelamin = new ButtonGroup();
        kelompokJenisKelamin.add(lakiLakiRadioButton);
        kelompokJenisKelamin.add(perempuanRadioButton);
        add(new JLabel("Jenis Kelamin:"));
        JPanel panel1 = new JPanel();
        panel1.add(lakiLakiRadioButton);
        panel1.add(perempuanRadioButton);
        add(panel1);

        // Golongan Darah Radio Buttons
        JRadioButton ARadioButton = new JRadioButton("A");
        JRadioButton BRadioButton = new JRadioButton("B");
        JRadioButton ABRadioButton = new JRadioButton("AB");
        JRadioButton ORadioButton = new JRadioButton("O");
        ButtonGroup kelompokGolonganDarah = new ButtonGroup();
        kelompokGolonganDarah.add(ARadioButton);
        kelompokGolonganDarah.add(BRadioButton);
        kelompokGolonganDarah.add(ABRadioButton);
        kelompokGolonganDarah.add(ORadioButton);
        add(new JLabel("Golongan Darah:"));
        JPanel panel2 = new JPanel();
        panel2.add(ARadioButton);
        panel2.add(BRadioButton);
        panel2.add(ABRadioButton);
        panel2.add(ORadioButton);
        add(panel2);

        add(new JLabel("Alamat:"));
        alamatField = new JTextField();
        add(alamatField);

        add(new JLabel("RT:"));
        rtField = new JTextField();
        add(rtField);

        add(new JLabel("RW:"));
        rwField = new JTextField();
        add(rwField);

        add(new JLabel("Kelurahan/Desa:"));
        kelDesaField = new JTextField();
        add(kelDesaField);

        add(new JLabel("Kecamatan:"));
        kecamatanField = new JTextField();
        add(kecamatanField);

        add(new JLabel("Agama:"));
        agamaCombo = new JComboBox<>(new String[] { "Islam", "Kristen", "Katholik", "Hindu", "Buddha", "Konghucu" });
        add(agamaCombo);

        add(new JLabel("Status Perkawinan:"));
        statusPerkawinanCombo = new JComboBox<>(new String[] { "BELUMMENIKAH", "MENIKAH", "JANDADUDA" });
        add(statusPerkawinanCombo);

        // Pekerjaan Checkboxes
        karyawanSwastaCheckBox = new JCheckBox("Karyawan Swasta");
        pnsCheckBox = new JCheckBox("PNS");
        wiraswastaCheckBox = new JCheckBox("Wiraswasta");
        akademisiCheckBox = new JCheckBox("Akademisi");
        pengangguranCheckBox = new JCheckBox("Pengangguran");
        add(new JLabel("Pekerjaan :"));
        add(karyawanSwastaCheckBox);
        add(pnsCheckBox);
        add(wiraswastaCheckBox);
        add(akademisiCheckBox);
        add(pengangguranCheckBox);
        pekerjaanField = new JTextField();
        pekerjaanField.setEditable(false);
        add(new JLabel("Pekerjaan (terpilih):"));
        add(pekerjaanField);

        // Kewarganegaraan Radio Buttons (WNI, WNA)
        JRadioButton wniRadioButton = new JRadioButton("WNI");
        JRadioButton wnaRadioButton = new JRadioButton("WNA");
        ButtonGroup kewarganegaraanGroup = new ButtonGroup();
        kewarganegaraanGroup.add(wniRadioButton);
        kewarganegaraanGroup.add(wnaRadioButton);
        add(new JLabel("Kewarganegaraan:"));
        JPanel panel3 = new JPanel();
        panel3.add(wniRadioButton);
        panel3.add(wnaRadioButton);
        add(panel3);

        add(new JLabel("Warga Negara Asal (Jika WNA):"));
        wargaNegaraAsalField = new JTextField();
        wargaNegaraAsalField.setVisible(false); // Make it invisible initially
        add(wargaNegaraAsalField);
        wnaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (wnaRadioButton.isSelected()) {
                    wargaNegaraAsalField.setVisible(true); // Show the input field
                }
            }
        });
        wniRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Jika WNI dipilih, sembunyikan input negara asal
                if (wniRadioButton.isSelected()) {
                    wargaNegaraAsalField.setVisible(false); // Menyembunyikan input negara asal jika WNI dipilih
                }
            }
        });

        // Foto and Tanda Tangan Buttons
        add(new JLabel("Foto:"));
        fotoButton = new JButton("Pilih Foto");
        add(fotoButton);

        add(new JLabel("Tanda Tangan:"));
        tandaTanganButton = new JButton("Pilih Tanda Tangan");
        add(tandaTanganButton);

        add(new JLabel("Berlaku Hingga:"));
        berlakuHinggaField = new JTextField();
        add(berlakuHinggaField);

        add(new JLabel("Kota Pembuatan:"));
        kotaPembuatanField = new JTextField();
        add(kotaPembuatanField);

        add(new JLabel("Tanggal Pembuatan:"));
        tanggalPembuatanField = new JTextField();
        add(tanggalPembuatanField);

        // Submit Button
        submitButton = new JButton("Submit");
        add(submitButton);

        // Clear Button
        clearButton = new JButton("Clear");
        add(clearButton);

        // Handle action on Pengangguran checkbox
        pengangguranCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pengangguranCheckBox.isSelected()) {
                    karyawanSwastaCheckBox.setEnabled(false);
                    pnsCheckBox.setEnabled(false);
                    wiraswastaCheckBox.setEnabled(false);
                    akademisiCheckBox.setEnabled(false);
                } else {
                    karyawanSwastaCheckBox.setEnabled(true);
                    pnsCheckBox.setEnabled(true);
                    wiraswastaCheckBox.setEnabled(true);
                    akademisiCheckBox.setEnabled(true);
                }
            }
        });

        // Handle action when any checkbox is changed
        ActionListener pekerjaanListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePekerjaanField();
            }
        };

        // Add listeners to all checkboxes
        karyawanSwastaCheckBox.addActionListener(pekerjaanListener);
        pnsCheckBox.addActionListener(pekerjaanListener);
        wiraswastaCheckBox.addActionListener(pekerjaanListener);
        akademisiCheckBox.addActionListener(pekerjaanListener);
    }

    // Method to update pekerjaan field based on selected checkboxes
    private void updatePekerjaanField() {
        StringBuilder pekerjaan = new StringBuilder();

        if (karyawanSwastaCheckBox.isSelected()) {
            pekerjaan.append("Karyawan Swasta, ");
        }
        if (pnsCheckBox.isSelected()) {
            pekerjaan.append("PNS, ");
        }
        if (wiraswastaCheckBox.isSelected()) {
            pekerjaan.append("Wiraswasta, ");
        }
        if (akademisiCheckBox.isSelected()) {
            pekerjaan.append("Akademisi, ");
        }

        // Remove last comma if there's one
        if (pekerjaan.length() > 0) {
            pekerjaan.setLength(pekerjaan.length() - 2); // Remove trailing comma
        }

        // If Pengangguran is selected, make it the only choice
        if (pengangguranCheckBox.isSelected()) {
            pekerjaan.setLength(0); // Clear other selections
            pekerjaan.append("Pengangguran");
        }

        pekerjaanField.setText(pekerjaan.toString());
    }

    // private JDatePickerImpl createDatePicker() {
    // // Date Picker Configuration
    // UtilDateModel model = new UtilDateModel();
    // Properties p = new Properties();
    // p.put("text.today", "Today");
    // p.put("text.month", "Month");
    // p.put("text.year", "Year");
    // JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    // return new JDatePickerImpl(datePanel, new DateLabelFormatter());
    // }

    // Formatter for Date Picker
    // public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter
    // {
    // private final String datePattern = "yyyy-MM-dd";
    // private final SimpleDateFormat dateFormatter = new
    // SimpleDateFormat(datePattern);

    // @Override
    // public Object stringToValue(String text) throws ParseException {
    // return dateFormatter.parse(text);
    // }

    // @Override
    // public String valueToString(Object value) {
    // if (value != null) {
    // return dateFormatter.format(value);
    // }
    // return "";
    // }
    // }

    public void printData() {
        System.out.println("NIK: " + nikField.getText());
        System.out.println("Nama: " + namaField.getText());
        System.out.println("Tempat Lahir: " + tempatLahirField.getText());
        System.out.println("Tanggal Lahir: " + tanggalLahirPicker.getText());
        System.out.println("Agama: " + agamaCombo.getSelectedItem());
        System.out.println("Status Perkawinan: " + statusPerkawinanCombo.getSelectedItem());
        System.out.println("Pekerjaan: " + pekerjaanField.getText());
        System.out.println("Kewarganegaraan: " + (wargaNegaraAsalField.isVisible() ? "WNA" : "WNI"));
        if (wargaNegaraAsalField.isVisible()) {
            System.out.println("Warga Negara Asal: " + wargaNegaraAsalField.getText());
        }
        System.out.println("Berlaku Hingga: " + berlakuHinggaField.getText());
        System.out.println("Kota Pembuatan: " + kotaPembuatanField.getText());
        System.out.println("Tanggal Pembuatan: " + tanggalPembuatanField.getText());
    }

}
