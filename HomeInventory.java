
package inventory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class HomeInventory extends javax.swing.JFrame {
    static final int maximumEntries = 300;
    static int numberEntries;
    static InventoryItem[] myInventory = new InventoryItem[maximumEntries];
    int currentEntry;
    static final int entriesPerPage = 2;
    static int lastPage;
    public HomeInventory() {
        initComponents();
        
        setTitle("Home Inventory Manager");
//        setResizable(false);
//        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        addWindowListener(new WindowAdapter() {
//        public void windowClosing(WindowEvent evt)
//                {
//                    exitForm(evt);
//                }
//
//            private void exitForm(WindowEvent evt) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//        getContentPane().setLayout(new GridBagLayout());
//        GridBagConstraints gridConstraints;
     
        
//        inventoryToolbar.setFloatable(false);
//        inventoryToolbar.setBackground(Color.BLUE);
//        inventoryToolbar.setOrientation(SwingConstants.VERTICAL);
//        
//        gridConstraints=new GridBagConstraints();
//        gridConstraints.gridx=0;
//        gridConstraints.gridy=0;
//        gridConstraints.gridheight=8;
//        gridConstraints.fill=GridBagConstraints.VERTICAL;
//        getContentPane().add(inventoryToolbar,gridConstraints);
//        
//        inventoryToolbar.addSeparator();
        //Dimension bSize=new Dimension(70, 50);
        
    try
        {
        
        BufferedReader inputFile = new BufferedReader(new FileReader("inventorydata.txt"));
        numberEntries =
        Integer.valueOf(inputFile.readLine()).intValue();
        if (numberEntries != 0)
        {
        for (int i = 0; i < numberEntries; i++)
        {
        myInventory[i] = new InventoryItem();
        myInventory[i].description = inputFile.readLine();
        myInventory[i].location = inputFile.readLine();
        myInventory[i].serialNumber = inputFile.readLine();
        myInventory[i].marked =
        Boolean.valueOf(inputFile.readLine()).booleanValue();
        myInventory[i].purchasePrice =

        inputFile.readLine();
        myInventory[i].purchaseDate = inputFile.readLine();
        myInventory[i].purchaseLocation =
        inputFile.readLine();
        myInventory[i].note = inputFile.readLine();
        myInventory[i].photoFile = inputFile.readLine();
        }
        }
            // read in combo box elements
            int n = Integer.valueOf(inputFile.readLine()).intValue();
        if (n != 0)
        {
        for (int i = 0; i < n; i++)
        {
        locationComboBox.addItem(inputFile.readLine());
        }
        }
        inputFile.close();
            int currentEntry = 1;
        showEntry(currentEntry);
        }
        catch (Exception ex)
        {
        numberEntries = 0;
            int currentEntry = 0;
        }
        if (numberEntries == 0)
        {
        newButton.setEnabled(false);
        deleteButton.setEnabled(false);
        nextButton.setEnabled(false);
        previousButton.setEnabled(false);
        printButton.setEnabled(false);
        }
        }
    
        private void exitForm(WindowEvent evt)
        {
        if (JOptionPane.showConfirmDialog(null, "Any unsaved changes will be lost.\nAre you sure you want to exit?", "Exit Program", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
        return;
         // write entries back to file
        try
        {
        PrintWriter outputFile = new PrintWriter(new BufferedWriter(new
        FileWriter("inventorydata.txt")));
        outputFile.println(numberEntries);
        if (numberEntries != 0)
        {
        for (int i = 0; i < numberEntries; i++)
        {
        outputFile.println(myInventory[i].description);
        outputFile.println(myInventory[i].location);
        outputFile.println(myInventory[i].serialNumber);
        outputFile.println(myInventory[i].marked);
        outputFile.println(myInventory[i].purchasePrice);
        outputFile.println(myInventory[i].purchaseDate);
        outputFile.println(myInventory[i].purchaseLocation);
        outputFile.println(myInventory[i].note);
        outputFile.println(myInventory[i].photoFile);
        }
        }
        // write combo box entries
        outputFile.println(locationComboBox.getItemCount());
        if (locationComboBox.getItemCount() != 0)
        {
        for (int i = 0; i < locationComboBox.getItemCount(); i++)
        outputFile.println(locationComboBox.getItemAt(i));
        }
        outputFile.close();
        }
        
         catch (Exception ex)
        {
        }
        System.exit(0);
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inventoryToolbar = new javax.swing.JToolBar();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        printButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        itemLabel = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        serialLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        storeLabel = new javax.swing.JLabel();
        noteLabel = new javax.swing.JLabel();
        photoLabel = new javax.swing.JLabel();
        itemTextField = new javax.swing.JTextField();
        serialTextField = new javax.swing.JTextField();
        priceTextField = new javax.swing.JTextField();
        storeTextField = new javax.swing.JTextField();
        noteTextField = new javax.swing.JTextField();
        markedCheckBox = new javax.swing.JCheckBox();
        dateLabel = new javax.swing.JLabel();
        photoButton = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        photoPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        locationComboBox = new javax.swing.JComboBox<>();
        dateDateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        photoTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        inventoryToolbar.setOrientation(javax.swing.SwingConstants.VERTICAL);
        inventoryToolbar.setRollover(true);

        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/New.png"))); // NOI18N
        newButton.setText("New");
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setMaximumSize(new java.awt.Dimension(151, 69));
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        inventoryToolbar.add(newButton);

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/clean_delete.png"))); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.setFocusable(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.setMaximumSize(new java.awt.Dimension(151, 69));
        deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        inventoryToolbar.add(deleteButton);

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/Save.png"))); // NOI18N
        saveButton.setText("Save");
        saveButton.setFocusable(false);
        saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveButton.setMaximumSize(new java.awt.Dimension(151, 69));
        saveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        inventoryToolbar.add(saveButton);
        inventoryToolbar.add(jSeparator1);

        previousButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/370091_back_backward_direction_left_previous_icon.png"))); // NOI18N
        previousButton.setText("Previous");
        previousButton.setFocusable(false);
        previousButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previousButton.setMaximumSize(new java.awt.Dimension(151, 69));
        previousButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });
        inventoryToolbar.add(previousButton);

        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/Next.png"))); // NOI18N
        nextButton.setText("Next");
        nextButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextButton.setFocusable(false);
        nextButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nextButton.setMaximumSize(new java.awt.Dimension(151, 69));
        nextButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        inventoryToolbar.add(nextButton);
        inventoryToolbar.add(jSeparator2);

        printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/2305642_doc_document_paper_print_printer_icon.png"))); // NOI18N
        printButton.setText("Print");
        printButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        printButton.setFocusable(false);
        printButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printButton.setMaximumSize(new java.awt.Dimension(151, 69));
        printButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        inventoryToolbar.add(printButton);

        exitButton.setText("Exit");
        exitButton.setFocusable(false);
        exitButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exitButton.setMaximumSize(new java.awt.Dimension(151, 69));
        exitButton.setMinimumSize(new java.awt.Dimension(151, 69));
        exitButton.setName(""); // NOI18N
        exitButton.setPreferredSize(new java.awt.Dimension(151, 49));
        exitButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        inventoryToolbar.add(exitButton);

        itemLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        itemLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        itemLabel.setText("Inventory Item");

        locationLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        locationLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        locationLabel.setText("Location");

        serialLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        serialLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        serialLabel.setText("Serial Number");

        priceLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        priceLabel.setText("Purchase Price");

        storeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        storeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        storeLabel.setText("Store/Website");

        noteLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        noteLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        noteLabel.setText("note");

        photoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        photoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        photoLabel.setText(" Photo");

        itemTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTextFieldActionPerformed(evt);
            }
        });

        serialTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serialTextFieldActionPerformed(evt);
            }
        });

        priceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextFieldActionPerformed(evt);
            }
        });

        storeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeTextFieldActionPerformed(evt);
            }
        });

        noteTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteTextFieldActionPerformed(evt);
            }
        });

        markedCheckBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        markedCheckBox.setText("Marked");

        dateLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dateLabel.setText("Date Purchase");

        photoButton.setText("Photo");
        photoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        photoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoButtonActionPerformed(evt);
            }
        });

        searchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Item Search"));

        jButton9.setBackground(new java.awt.Color(255, 255, 102));
        jButton9.setText("A");
        jButton9.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton10.setBackground(new java.awt.Color(255, 255, 102));
        jButton10.setText("B");
        jButton10.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton11.setBackground(new java.awt.Color(255, 255, 102));
        jButton11.setText("C");
        jButton11.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton12.setBackground(new java.awt.Color(255, 255, 102));
        jButton12.setText("D");
        jButton12.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton14.setBackground(new java.awt.Color(255, 255, 102));
        jButton14.setText("F");
        jButton14.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton15.setBackground(new java.awt.Color(255, 255, 102));
        jButton15.setText("G");
        jButton15.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton16.setBackground(new java.awt.Color(255, 255, 102));
        jButton16.setText("H");
        jButton16.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton17.setBackground(new java.awt.Color(255, 255, 102));
        jButton17.setText("I");
        jButton17.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton18.setBackground(new java.awt.Color(255, 255, 102));
        jButton18.setText("J");
        jButton18.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton19.setBackground(new java.awt.Color(255, 255, 102));
        jButton19.setText("K");
        jButton19.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton20.setBackground(new java.awt.Color(255, 255, 102));
        jButton20.setText("L");
        jButton20.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton21.setBackground(new java.awt.Color(255, 255, 102));
        jButton21.setText("M");
        jButton21.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton22.setBackground(new java.awt.Color(255, 255, 102));
        jButton22.setText("N");
        jButton22.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton23.setBackground(new java.awt.Color(255, 255, 102));
        jButton23.setText("O");
        jButton23.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton24.setBackground(new java.awt.Color(255, 255, 102));
        jButton24.setText("P");
        jButton24.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton25.setBackground(new java.awt.Color(255, 255, 102));
        jButton25.setText("Q");
        jButton25.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton26.setBackground(new java.awt.Color(255, 255, 102));
        jButton26.setText("R");
        jButton26.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton13.setBackground(new java.awt.Color(255, 255, 102));
        jButton13.setText("E");
        jButton13.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton27.setBackground(new java.awt.Color(255, 255, 102));
        jButton27.setText("S");
        jButton27.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton28.setBackground(new java.awt.Color(255, 255, 102));
        jButton28.setText("T");
        jButton28.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton29.setBackground(new java.awt.Color(255, 255, 102));
        jButton29.setText("U");
        jButton29.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton30.setBackground(new java.awt.Color(255, 255, 102));
        jButton30.setText("V");
        jButton30.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton31.setBackground(new java.awt.Color(255, 255, 102));
        jButton31.setText("W");
        jButton31.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton32.setBackground(new java.awt.Color(255, 255, 102));
        jButton32.setText("X");
        jButton32.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton33.setBackground(new java.awt.Color(255, 255, 102));
        jButton33.setText("Y");
        jButton33.setMaximumSize(new java.awt.Dimension(0, 0));

        jButton34.setBackground(new java.awt.Color(255, 255, 102));
        jButton34.setText("Z");
        jButton34.setMaximumSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        photoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout photoPanelLayout = new javax.swing.GroupLayout(photoPanel);
        photoPanel.setLayout(photoPanelLayout);
        photoPanelLayout.setHorizontalGroup(
            photoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        photoPanelLayout.setVerticalGroup(
            photoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Inventory Management");

        locationComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bhopal", "Indore", "Jawalpur", "Gawalior", "Sagar", "Rewa", "Satna" }));
        locationComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationComboBoxActionPerformed(evt);
            }
        });

        photoTextArea.setBackground(new java.awt.Color(255, 255, 71));
        photoTextArea.setColumns(20);
        photoTextArea.setRows(5);
        jScrollPane1.setViewportView(photoTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inventoryToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(serialLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(itemLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(locationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(priceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(storeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(noteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(photoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(locationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(markedCheckBox))
                                    .addComponent(serialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(itemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(dateLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(photoButton))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(storeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                                        .addComponent(noteTextField)))
                                .addGap(0, 15, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(photoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(locationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(locationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(markedCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(serialLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(storeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(storeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(noteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(noteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(dateDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                            .addComponent(photoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(photoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(inventoryToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        
        checkSave();
        currentEntry--;
        showEntry(currentEntry);
        
    }//GEN-LAST:event_previousButtonActionPerformed

    private void itemTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTextFieldActionPerformed
            locationComboBox.requestFocus();
    }//GEN-LAST:event_itemTextFieldActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
                checkSave();
                blankValues();
    }//GEN-LAST:event_newButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        
        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this item?","Delete Inventory Item", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION)
        return;
        deleteEntry(currentEntry);
        if (numberEntries == 0)
        {
        currentEntry = 0;
        blankValues();
        }
        else
        {
        currentEntry--;
        if (currentEntry == 0)
        currentEntry = 1;
        showEntry(currentEntry);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
       // check for description

        itemTextField.setText(itemTextField.getText().trim());
        if (itemTextField.getText().equals(""))
        {
        JOptionPane.showConfirmDialog(null, "Must have item description.", "Error",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE); itemTextField.requestFocus();
        return;
        }
        if (newButton.isEnabled())
        {
        // delete edit entry then resave
        deleteEntry(currentEntry);
        }
        // capitalize first letter
        String s = itemTextField.getText();
        itemTextField.setText(s.substring(0, 1).toUpperCase() + s.substring(1));
        numberEntries++;
        // determine new current entry location based on description
        currentEntry = 1;
        if (numberEntries != 1)
        {
        do
        {
        if
        (itemTextField.getText().compareTo(myInventory[currentEntry - 1].description) < 0)
        break;
        currentEntry++;
        }
        while (currentEntry < numberEntries);
        }
        // move all entries below new value down one position unless at end
        if (currentEntry != numberEntries)
        {
        for (int i = numberEntries; i >= currentEntry + 1; i--)
        {
        myInventory[i - 1] = myInventory[i - 2];
        myInventory[i - 2] = new InventoryItem();
        }
        }
        myInventory[currentEntry - 1] = new InventoryItem();
        myInventory[currentEntry - 1].description = itemTextField.getText();
        myInventory[currentEntry - 1].location =
        locationComboBox.getSelectedItem().toString();
        myInventory[currentEntry - 1].marked = markedCheckBox.isSelected();
        myInventory[currentEntry - 1].serialNumber = serialTextField.getText();
        myInventory[currentEntry - 1].purchasePrice = priceTextField.getText();
        myInventory[currentEntry - 1].purchaseDate =dateToString(dateDateChooser.getDate());
        myInventory[currentEntry - 1].purchaseLocation = storeTextField.getText();
        //Create a photoTextArea Class to getText
        myInventory[currentEntry - 1].photoFile = photoTextArea.getText();
        myInventory[currentEntry - 1].note = noteTextField.getText();
        showEntry(currentEntry);
        if (numberEntries < maximumEntries)
        newButton.setEnabled(true);
        else
        newButton.setEnabled(false);
        deleteButton.setEnabled(true);
        printButton.setEnabled(true);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        
        checkSave();
        currentEntry++;
        showEntry(currentEntry);
        
    }//GEN-LAST:event_nextButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
       
        lastPage = (int) (1 + (numberEntries - 1) / entriesPerPage);
        PrinterJob inventoryPrinterJob = PrinterJob.getPrinterJob();
        inventoryPrinterJob.setPrintable((Printable) new InventoryDocument());
        if (inventoryPrinterJob.printDialog())
        {
        try
        {
        inventoryPrinterJob.print();
        }
        catch (PrinterException ex)
        {
        JOptionPane.showConfirmDialog(null, ex.getMessage(), "Print Error",
        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_printButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        exitForm(null);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void photoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photoButtonActionPerformed
                
        JFileChooser openChooser = new JFileChooser();
        openChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        openChooser.setDialogTitle("Open Photo File");
        openChooser.addChoosableFileFilter(new FileNameExtensionFilter("Photo Files",
        "jpg"));
        if (openChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        showPhoto(openChooser.getSelectedFile().toString());
        
    }//GEN-LAST:event_photoButtonActionPerformed

    private void locationComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationComboBoxActionPerformed
            
        // If in list - exit method
        if (locationComboBox.getItemCount() != 0)
        {
        for (int i = 0; i < locationComboBox.getItemCount(); i++)
        {
        if (locationComboBox.getSelectedItem().toString().equals(locationComboBox.getItemAt(i).toString()))
        {
        serialTextField.requestFocus();
        return;
        }
        }
        }
        // If not found, add to list box
        locationComboBox.addItem((String) locationComboBox.getSelectedItem());
        serialTextField.requestFocus();
        
    }//GEN-LAST:event_locationComboBoxActionPerformed

    private void serialTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serialTextFieldActionPerformed
        priceTextField.requestFocus();
    }//GEN-LAST:event_serialTextFieldActionPerformed

    private void priceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextFieldActionPerformed
        dateDateChooser.requestFocus();
    }//GEN-LAST:event_priceTextFieldActionPerformed

    private void storeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storeTextFieldActionPerformed
        noteTextField.requestFocus();
    }//GEN-LAST:event_storeTextFieldActionPerformed

    private void noteTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteTextFieldActionPerformed
        photoButton.requestFocus();
    }//GEN-LAST:event_noteTextFieldActionPerformed

    private void dateDateChooserActionPerformed(java.awt.event.ActionEvent evt) {                                              
        storeTextField.requestFocus();
    }
  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeInventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateDateChooser;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JToolBar inventoryToolbar;
    private javax.swing.JLabel itemLabel;
    private javax.swing.JTextField itemTextField;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JComboBox<String> locationComboBox;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JCheckBox markedCheckBox;
    private javax.swing.JButton newButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JTextField noteTextField;
    private javax.swing.JButton photoButton;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JPanel photoPanel;
    static javax.swing.JTextArea photoTextArea;
    private javax.swing.JButton previousButton;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JButton printButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JLabel serialLabel;
    private javax.swing.JTextField serialTextField;
    private javax.swing.JLabel storeLabel;
    private javax.swing.JTextField storeTextField;
    // End of variables declaration//GEN-END:variables

    private void showEntry(int j) {
        
        // display entry j (1 to numberEntries)
        itemTextField.setText(myInventory[j - 1].description);
        locationComboBox.setSelectedItem(myInventory[j - 1].location);
        markedCheckBox.setSelected(myInventory[j - 1].marked);
        serialTextField.setText(myInventory[j - 1].serialNumber);
        priceTextField.setText(myInventory[j - 1].purchasePrice);
        dateDateChooser.setDate(stringToDate(myInventory[j - 1].purchaseDate));
        storeTextField.setText(myInventory[j - 1].purchaseLocation);
        noteTextField.setText(myInventory[j - 1].note);
        showPhoto(myInventory[j - 1].photoFile);
        nextButton.setEnabled(true);
        previousButton.setEnabled(true);
        if (j == 1)
        previousButton.setEnabled(false);
        if (j == numberEntries)
        nextButton.setEnabled(false);
        itemTextField.requestFocus();
        
    }

    private void checkSave() {
        
        boolean edited = false;
        if (!myInventory[currentEntry - 1].description.equals(itemTextField.getText()))
        edited = true;
        else if (!myInventory[currentEntry -1].location.equals(locationComboBox.getSelectedItem().toString()))
        edited = true;
        else if (myInventory[currentEntry - 1].marked != markedCheckBox.isSelected())
        edited = true;
        else if (!myInventory[currentEntry - 1].serialNumber.equals(serialTextField.getText()))
        edited = true;
        else if (!myInventory[currentEntry - 1].purchasePrice.equals(priceTextField.getText()))
        edited = true;
        else if (!myInventory[currentEntry -1].purchaseDate.equals(dateToString(dateDateChooser.getDate())))
        edited = true;
        else if (!myInventory[currentEntry -
        1].purchaseLocation.equals(storeTextField.getText()))
        edited = true;
        else if (!myInventory[currentEntry - 1].note.equals(noteTextField.getText()))
        edited = true;
        else if (!myInventory[currentEntry - 1].photoFile.equals(photoTextArea.getText()))
        edited = true;
        if (edited)
        {
        if (JOptionPane.showConfirmDialog(null, "You have edited this item. Do you want to save the changes?", "Save Item", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
        saveButton.doClick();
        }
    }

    private void blankValues() {
        
        // blank input screen
        newButton.setEnabled(false);
        deleteButton.setEnabled(false);
        saveButton.setEnabled(true);
        previousButton.setEnabled(false);
        nextButton.setEnabled(false);
        printButton.setEnabled(false);
        itemTextField.setText("");
        locationComboBox.setSelectedItem("");
        markedCheckBox.setSelected(false);
        serialTextField.setText("");
        priceTextField.setText("");
        dateDateChooser.setDate(new Date());
        storeTextField.setText("");
        noteTextField.setText("");
        photoTextArea.setText("");
        photoPanel.repaint();
        itemTextField.requestFocus();
        
    }

    private void deleteEntry(int j) {
        
        // delete entry j
        if (j != numberEntries)
        {
        // move all entries under j up one level
        for (int i = j; i < numberEntries; i++)
        {
        myInventory[i - 1] = new InventoryItem();
        myInventory[i - 1] = myInventory[i];
        }
        }
        numberEntries--;
        
    }

    private String dateToString(Date dd) {
        
        String yString = String.valueOf(dd.getYear() + 1900);
        int m = dd.getMonth() + 1;
        String mString = new DecimalFormat("00").format(m);
        int d = dd.getDate();
        String dString = new DecimalFormat("00").format(d);
        return(mString + "/" + dString + "/" + yString);
        
    }

    private void showPhoto(String photoFile) {
        
        if (!photoFile.equals(""))
        {
        try
        {
        photoTextArea.setText(photoFile);
        }
        catch (Exception ex)
        {
        photoTextArea.setText("");
        }
        }
        else
        {
        photoTextArea.setText("");
        }
        photoPanel.repaint();
        
    }

    private Date stringToDate(String s) {
       
        int m = Integer.valueOf(s.substring(0, 2)).intValue() - 1;
        int d = Integer.valueOf(s.substring(3, 5)).intValue();
        int y = Integer.valueOf(s.substring(6)).intValue() - 1900;
        return(new Date(y, m, d));
        
    }

}

class PhotoPanel extends JPanel{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g2D);
        // draw border
        g2D.setPaint(Color.BLACK);
        g2D.draw(new Rectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1));
        // show photo
        Image photoImage = new ImageIcon(HomeInventory.photoTextArea.getText()).getImage();
        int w = getWidth();
        int h = getHeight();
        double rWidth = (double) getWidth() / (double) photoImage.getWidth(null);
        double rHeight = (double) getHeight() / (double) photoImage.getHeight(null);
        if (rWidth > rHeight)
        {
        // leave height at display height, change width by amount height is changed
        w = (int) (photoImage.getWidth(null) * rHeight);
        }
        else
        {
        // leave width at display width, change height by amount width is changed
        h = (int) (photoImage.getHeight(null) * rWidth);
        }
        // center in panel
        g2D.drawImage(photoImage, (int) (0.5 * (getWidth() - w)), (int) (0.5 * (getHeight() - h)), w, h, null);
        g2D.dispose();
    }
}

class InventoryDocument implements Printable{

    public InventoryDocument() {
    }

    public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
        Graphics2D g2D = (Graphics2D) g;
        if ((pageIndex + 1) > HomeInventory.lastPage)
        {
        return NO_SUCH_PAGE;
        }
        int i, iEnd;

        g2D.setFont(new Font("Arial", Font.BOLD, 14));
        g2D.drawString("Home Inventory Items - Page " + String.valueOf(pageIndex + 1),
        (int) pf.getImageableX(), (int) (pf.getImageableY() + 25));
        // get starting y
        int dy = (int) g2D.getFont().getStringBounds("S",
        g2D.getFontRenderContext()).getHeight();
        int y = (int) (pf.getImageableY() + 4 * dy);
        iEnd = HomeInventory.entriesPerPage * (pageIndex + 1);
        if (iEnd > HomeInventory.numberEntries)
        iEnd = HomeInventory.numberEntries;
        for (i = 0 + HomeInventory.entriesPerPage * pageIndex; i < iEnd; i++)
        {
           
            Line2D.Double dividingLine = new Line2D.Double(pf.getImageableX(), y, pf.getImageableX() + pf.getImageableWidth(), y);
            g2D.draw(dividingLine);
            y += dy;
            g2D.setFont(new Font("Arial", Font.BOLD, 12));
            g2D.drawString(HomeInventory.myInventory[i].description, (int) pf.getImageableX(), y);
            y += dy;
            g2D.setFont(new Font("Arial", Font.PLAIN, 12));
            g2D.drawString("Location: " + HomeInventory.myInventory[i].location, (int)(pf.getImageableX() + 25), y);
            y += dy;
            if (HomeInventory.myInventory[i].marked)
                g2D.drawString("Item is marked with identifying information.", (int)(pf.getImageableX() + 25), y);
            else
               g2D.drawString("Item is NOT marked with identifying information.", (int)(pf.getImageableX() + 25), y);
                y += dy;
               g2D.drawString("Serial Number: " + HomeInventory.myInventory[i].serialNumber, (int) (pf.getImageableX() + 25), y);
                y += dy;
                g2D.drawString("Price: $" + HomeInventory.myInventory[i].purchasePrice + ",Purchased on: " + HomeInventory.myInventory[i].purchaseDate, (int) (pf.getImageableX() +25), y);
                y += dy;
                g2D.drawString("Purchased at: " +HomeInventory.myInventory[i].purchaseLocation, (int) (pf.getImageableX() + 25), y);
                y += dy;
                g2D.drawString("Note: " + HomeInventory.myInventory[i].note, (int)(pf.getImageableX() + 25), y);
                y += dy;
            try
            {

                Image inventoryImage = new ImageIcon(HomeInventory.myInventory[i].photoFile).getImage();
                double ratio = (double) (inventoryImage.getWidth(null)) / (double)inventoryImage.getHeight(null);
                 g2D.drawImage(inventoryImage, (int) (pf.getImageableX() + 25), y, (int) (100 * ratio), 100, null);
            }
            catch (Exception ex)
            {
  
            }
                y += 2 * dy + 100;
        }
    return PAGE_EXISTS;

          }
    
}