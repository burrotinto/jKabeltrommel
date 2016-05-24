package de.swneumarkt.jKabeltrommel.dispalyAS.LieferantCreateAS;

import de.swneumarkt.jKabeltrommel.dbauswahlAS.IDBWrapper;
import de.swneumarkt.jKabeltrommel.dbauswahlAS.entytis.LieferantE;
import de.swneumarkt.jKabeltrommel.dispalyAS.LieferantAuswahlAS.LieferantenAuswahlAAS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by derduke on 24.05.16.
 */
public class LieferantCreateAAS extends JDialog implements ActionListener {
    private final IDBWrapper db;
    private final LieferantenAuswahlAAS lAAS;

    private JTextField name = new JTextField();
    private JButton cancel = new JButton("Abbruch");
    private JButton create = new JButton("Erstellen");


    public LieferantCreateAAS(IDBWrapper db, LieferantenAuswahlAAS lAAS) {
        this.db = db;
        this.lAAS = lAAS;
        setLayout(new BorderLayout());
        add(new JLabel("Lieferant hinzufügen"), BorderLayout.NORTH);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 2));
        p.add(new JLabel("Name:"));
        p.add(name);
        add(p, BorderLayout.CENTER);
        JPanel south = new JPanel(new FlowLayout());
        south.add(cancel);
        south.add(create);
        add(south, BorderLayout.SOUTH);

        cancel.addActionListener(this);
        create.addActionListener(this);

        setLocationRelativeTo(null);
        setVisible(true);
        pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create) {
            try {
                db.create(new LieferantE(-1,name.getText()));
                lAAS.hastToUpdate();
            } catch (Exception x) {
                //TODO
            }
        }

        dispose();

    }
}