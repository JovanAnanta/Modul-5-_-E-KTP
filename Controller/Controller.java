package Controller;

import Model.*;
import Model.JenisKelamin;
import View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private KTP model;
    private FormInput view;

    public Controller(KTP model, FormInput view) {
        this.model = model;
        this.view = view;

        // Add Action Listeners
        view.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveKTPData();
            }
        });

        view.clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
    }

    private void saveKTPData() {
        try {
            model.setNik(view.nikField.getText());
            model.setNama(view.namaField.getText());
            model.setTempatLahir(view.tempatLahirField.getText());
            model.setTanggalLahir(view.tanggalLahirPicker.getText());
            // model.setTanggalLahir(view.tanggalLahirPicker.getJFormattedTextField().getText());
            model.setJenisKelamin(
                    view.jenisKelaminCombo.getSelectedItem().toString().equals("PRIA")
                            ? JenisKelamin.PRIA
                            : JenisKelamin.WANITA);
            model.setGolDarah(view.golDarahField.getText());
            model.setAlamat(view.alamatField.getText());
            model.setRt(view.rtField.getText());
            model.setRw(view.rwField.getText());
            model.setKelDesa(view.kelDesaField.getText());
            model.setKecamatan(view.kecamatanField.getText());
            model.setAgama(JenisAgama.valueOf(view.agamaCombo.getSelectedItem().toString().toUpperCase()));
            model.setStatusPerkawinan(StatusPerkawinan
                    .valueOf(view.statusPerkawinanCombo.getSelectedItem().toString().toUpperCase().replace(" ", "_")));
            model.setPekerjaan(view.pekerjaanField.getText());
            model.setKewarganegaraan(view.kewarganegaraanField.getText());
            model.setWargaNegaraAsal(view.wargaNegaraAsalField.getText());
            model.setBerlakuHingga(view.berlakuHinggaField.getText());
            model.setKotaPembuatan(view.kotaPembuatanField.getText());
            model.setTanggalPembuatan(view.tanggalPembuatanField.getText());

            JOptionPane.showMessageDialog(view, "Data KTP berhasil disimpan:\n" + model.toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        view.nikField.setText("");
        view.namaField.setText("");
        view.tempatLahirField.setText("");
        view.tanggalLahirPicker.setText("");
        view.golDarahField.setText("");
        view.alamatField.setText("");
        view.rtField.setText("");
        view.rwField.setText("");
        view.kelDesaField.setText("");
        view.kecamatanField.setText("");
        view.pekerjaanField.setText("");
        view.kewarganegaraanField.setText("");
        view.wargaNegaraAsalField.setText("");
        view.berlakuHinggaField.setText("");
        view.kotaPembuatanField.setText("");
        view.tanggalPembuatanField.setText("");
        view.jenisKelaminCombo.setSelectedIndex(0);
        view.agamaCombo.setSelectedIndex(0);
        view.statusPerkawinanCombo.setSelectedIndex(0);
    }
}
