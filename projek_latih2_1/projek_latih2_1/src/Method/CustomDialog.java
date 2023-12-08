
package Method;


import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import palette.*;


public class CustomDialog extends JDialog {

    public CustomDialog(JFrame parentFrame) {
        super(parentFrame, "Error", true);
        initComponents();
    }

    private void initComponents() {
        PanelCustom dialogPanel = new PanelCustom();
        JLabel dialogLabel = new JLabel("username or password is invalid");
        dialogPanel.add(dialogLabel);

        add(dialogPanel);
        setLocationRelativeTo(null);
        setSize(150, 150);
    }
}
