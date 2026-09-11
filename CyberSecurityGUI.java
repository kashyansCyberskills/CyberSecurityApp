import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CyberSecurityGUI {

    
    static String[] moduleNames = {
        "Phishing", "Malware", "Cyber Bullying", "Social Engineering",
        "Cryptojacking", "SQL Injection", "Cyber Terrorism", 
        "Zero-Day Exploitation", "Digital Vandalism", "Rootkits & Trojans"
    };

    static String[] moduleDescriptions = {
        "PHISHING\n\n" +
        "Phishing is a cyber attack where criminals disguise themselves as trustworthy sources " +
        "to steal sensitive information like passwords and credit card numbers.\n\n" +
        "Common Methods:\n" +
        "  - Fake emails pretending to be from banks\n" +
        "  - Fake login pages\n" +
        "  - Suspicious SMS (Smishing) or Voice calls (Vishing)\n\n" +
        "How to Stay Safe:\n" +
        "  - Never click unverified links\n" +
        "  - Check sender addresses carefully\n" +
        "  - Enable Multi-Factor Authentication (MFA)",

        "MALWARE\n\n" +
        "Malware (Malicious Software) is an umbrella term for software designed to harm or " +
        "exploit digital devices.\n\n" +
        "Types:\n" +
        "  - Ransomware: Locks files until a ransom is paid\n" +
        "  - Spyware: Secretly monitors user activities\n" +
        "  - Adware: Forces unwanted advertisements\n\n" +
        "How to Stay Safe:\n" +
        "  - Keep security software updated\n" +
        "  - Avoid untrusted websites and downloads",

        "CYBER BULLYING\n\n" +
        "Cyberbullying is the deliberate use of digital communication tools to harass, " +
        "intimidate, or defame someone.\n\n" +
        "Forms:\n" +
        "  - Direct abusive messages\n" +
        "  - Spreading harmful rumors or false content\n" +
        "  - Doxxing (sharing private information without consent)\n\n" +
        "How to Stay Safe:\n" +
        "  - Block and report abusive accounts\n" +
        "  - Maintain evidence (screenshots)\n" +
        "  - Reach out to trusted entities or authorities",

        "SOCIAL ENGINEERING\n\n" +
        "Social Engineering relies on human psychology rather than technical exploits to trick " +
        "people into revealing confidential data.\n\n" +
        "Common Tactics:\n" +
        "  - Pretexting: Fabricating scenarios to build trust\n" +
        "  - Baiting: Offering free items to trap users\n" +
        "  - Tailgating: Following authorized personnel into restricted areas\n\n" +
        "How to Stay Safe:\n" +
        "  - Verify identities independently\n" +
        "  - Be skeptical of urgent or pressure-filled requests",

        "CRYPTOJACKING\n\n" +
        "Cryptojacking occurs when attackers covertly hijack target computing power to mine " +
        "cryptocurrencies without authorization.\n\n" +
        "Signs of Infection:\n" +
        "  - Unexplained spikes in CPU or GPU usage\n" +
        "  - Overheating and loud cooling fans\n" +
        "  - Severe system slowdowns\n\n" +
        "How to Stay Safe:\n" +
        "  - Use ad-blockers and anti-crypto mining browser plugins\n" +
        "  - Monitor resource performance using Task Manager",

        "SQL INJECTION (SQLi)\n\n" +
        "SQL Injection is a vulnerability where malicious SQL commands are inserted into " +
        "input fields to manipulate database queries.\n\n" +
        "Impact:\n" +
        "  - Unauthorized data retrieval\n" +
        "  - Data modification or deletion\n" +
        "  - Administrative access takeover\n\n" +
        "How to Prevent:\n" +
        "  - Use Prepared Statements (Parameterized Queries)\n" +
        "  - Implement strict input validation and sanitization",

        "CYBER TERRORISM\n\n" +
        "Cyber Terrorism involves politically or ideologically motivated attacks against public " +
        "infrastructure, emergency systems, or governmental databases.\n\n" +
        "Targets:\n" +
        "  - Electrical power grids\n" +
        "  - Financial networks and banks\n" +
        "  - Water supply systems and air traffic control\n\n" +
        "Defense Measures:\n" +
        "  - Air-gapping critical infrastructure systems\n" +
        "  - Implementing strict intrusion detection protocols",

        "ZERO-DAY EXPLOITATION\n\n" +
        "A Zero-Day vulnerability is a software flaw unknown to the vendor, leaving zero days " +
        "to fix it before attackers exploit it.\n\n" +
        "Key Concepts:\n" +
        "  - Zero-Day Vulnerability: The undiscovered security bug\n" +
        "  - Zero-Day Exploit: Code developed by attackers to use the bug\n" +
        "  - Zero-Day Patch: Fix released by software developers\n\n" +
        "Defense Strategies:\n" +
        "  - Implement Web Application Firewalls (WAF)\n" +
        "  - Apply automatic software updates as soon as released",

        "DIGITAL VANDALISM\n\n" +
        "Digital Vandalism involves defacing websites, corrupting public data, or damaging " +
        "online assets for notoriety or mischief.\n\n" +
        "Examples:\n" +
        "  - Replacing homepages with custom graffiti images\n" +
        "  - Modifying Wikipedia articles with false information\n" +
        "  - Flooding comment sections with spam botnets\n\n" +
        "Defense:\n" +
        "  - Enforce strong access control roles\n" +
        "  - Maintain continuous automated backups",

        "ROOTKITS & TROJAN HORSES\n\n" +
        "Rootkits hide deeply within an operating system to grant administrative privilege, " +
        "while Trojans disguise themselves as legitimate programs.\n\n" +
        "Characteristics:\n" +
        "  - Trojans create backdoors for unauthorized access\n" +
        "  - Rootkits conceal processes, files, and remote access logs\n\n" +
        "How to Stay Safe:\n" +
        "  - Download software exclusively from official vendors\n" +
        "  - Conduct deep system scans with specialized rootkit removal tools"
    };

    
    enum QuestionType { TRUE_FALSE, MCQ, FILL_IN_BLANK }

    static class Question {
        String questionText;
        QuestionType type;
        String[] options;
        String correctAnswer;
        String explanation;

        
        Question(QuestionType type, String q, String[] opts, String ans, String exp) {
            this.type = type;
            this.questionText = q;
            this.options = (opts != null) ? opts : (type == QuestionType.TRUE_FALSE ? new String[]{"True", "False"} : null);
            this.correctAnswer = ans;
            this.explanation = exp;
        }
    }

    static List<Question> questionBank = new ArrayList<>();

    static void initQuestions() {
        questionBank.clear();

        
        questionBank.add(new Question(QuestionType.TRUE_FALSE, "Phishing emails always come from completely unknown senders.", null, "False", "Attackers can spoof known email addresses to appear legitimate."));
        questionBank.add(new Question(QuestionType.MCQ, "Which term describes phishing attacks conducted over SMS text messages?", new String[]{"Vishing", "Smishing", "Whaling", "Pharming"}, "Smishing", "Smishing stands for SMS Phishing."));
        questionBank.add(new Question(QuestionType.FILL_IN_BLANK, "Phishing attacks aiming directly at high-profile executives are called ________.", null, "Whaling", "Whaling targets senior executives for high-level credentials."));
        questionBank.add(new Question(QuestionType.MCQ, "Which of the following helps stop unauthorized account access during phishing?", new String[]{"Dark Mode", "Two-Factor Authentication", "Screen Saver", "Ad Blocker"}, "Two-Factor Authentication", "2FA stops logins even if a password is stolen."));

        
        questionBank.add(new Question(QuestionType.TRUE_FALSE, "Malware can easily spread via infected USB flash drives.", null, "True", "Plugging an unknown USB drive can execute malicious autorun scripts."));
        questionBank.add(new Question(QuestionType.FILL_IN_BLANK, "Software that encrypts your files and demands money for keys is called ________.", null, "Ransomware", "Ransomware locks data until payment is made."));
        questionBank.add(new Question(QuestionType.MCQ, "Which type of malware continuously monitors user activities without knowledge?", new String[]{"Spyware", "Adware", "Worm", "Rootkit"}, "Spyware", "Spyware tracks user inputs, browsing habits, and credentials."));
        questionBank.add(new Question(QuestionType.TRUE_FALSE, "Antivirus programs can detect malware using signature detection.", null, "True", "Known malware signatures help tools identify threats."));

        
        questionBank.add(new Question(QuestionType.TRUE_FALSE, "Cyberbullying only occurs on social media platforms.", null, "False", "It can happen on online games, messaging platforms, and forums."));
        questionBank.add(new Question(QuestionType.FILL_IN_BLANK, "Publicly releasing private identifying info about someone online is called ________.", null, "Doxxing", "Doxxing involves sharing personal data to harm a target."));
        questionBank.add(new Question(QuestionType.MCQ, "What is the best immediate step if you receive cyberbullying messages?", new String[]{"Argue back", "Save evidence and block", "Delete account", "Forward to friends"}, "Save evidence and block", "Documenting proof helps reports made to platforms or authorities."));

        
        questionBank.add(new Question(QuestionType.TRUE_FALSE, "Social engineering attacks primary target technical network vulnerabilities.", null, "False", "Social engineering tricks humans rather than breaking software."));
        questionBank.add(new Question(QuestionType.FILL_IN_BLANK, "Following an authorized person through a secure door without scanning is called ________.", null, "Tailgating", "Tailgating is gaining physical entrance by following authorized staff."));
        questionBank.add(new Question(QuestionType.MCQ, "When an attacker creates a fake scenario to gain your trust, it is known as:", new String[]{"Pretexting", "Spoofing", "Buffer Overflow", "Cross-site Scripting"}, "Pretexting", "Pretexting uses invented narratives to extract info."));
        questionBank.add(new Question(QuestionType.TRUE_FALSE, "Baiting involves offering something alluring to trick victims into malware install.", null, "True", "Free USB drives or download links act as 'bait'."));

        
        questionBank.add(new Question(QuestionType.TRUE_FALSE, "Cryptojacking secretly uses your device's hardware to mine cryptocurrency.", null, "True", "Cryptojacking consumes victim CPU/GPU power without consent."));
        questionBank.add(new Question(QuestionType.MCQ, "A major warning sign of cryptojacking on a computer is:", new String[]{"Instant shut down", "Unusually high CPU usage and heat", "Lost WiFi connection", "Changed wallpaper"}, "Unusually high CPU usage and heat", "Mining requires intensive processing power, driving heat up."));
        questionBank.add(new Question(QuestionType.TRUE_FALSE, "Cryptojacking scripts can run directly inside web browsers.", null, "True", "Malicious scripts embedded on web pages can hijack hardware while visiting."));

        
        questionBank.add(new Question(QuestionType.FILL_IN_BLANK, "SQL Injection targets the ________ layer of a web application.", null, "Database", "SQLi executes commands against back-end relational databases."));
        questionBank.add(new Question(QuestionType.MCQ, "Which coding technique effectively prevents SQL Injection vulnerabilities?", new String[]{"Prepared Statements", "CSS styling", "HTML tables", "Encryption keys"}, "Prepared Statements", "Parameterized queries separate SQL commands from user input."));
        questionBank.add(new Question(QuestionType.TRUE_FALSE, "SQL Injection can allow attackers to bypass standard login forms.", null, "True", "Inserting boolean true scripts like \"OR 1=1\" bypasses checks."));
        questionBank.add(new Question(QuestionType.FILL_IN_BLANK, "SQL stands for Structured ________ Language.", null, "Query", "SQL stands for Structured Query Language."));

        
        questionBank.add(new Question(QuestionType.TRUE_FALSE, "Cyber terrorism usually focuses on monetary extortion rather than political goals.", null, "False", "Cyber terrorism is motivated by political, religious, or ideological goals."));
        questionBank.add(new Question(QuestionType.FILL_IN_BLANK, "Physical isolation of a critical network from external networks is called ________.", null, "Air-gapping", "Air-gapped networks lack direct internet connections for security."));
        questionBank.add(new Question(QuestionType.MCQ, "Which target represents a typical critical objective for cyber terrorists?", new String[]{"Personal blog", "Electrical power grid", "Mobile game server", "Online clothing store"}, "Electrical power grid", "Terrorists aim for infrastructure like power, water, or finance."));

        
        questionBank.add(new Question(QuestionType.TRUE_FALSE, "A Zero-Day vulnerability is a bug that has been patched for over zero days.", null, "False", "Zero-day means developers have 0 days of awareness before exploit usage."));
        questionBank.add(new Question(QuestionType.FILL_IN_BLANK, "An undiscovered security flaw in a program is a Zero-Day ________.", null, "Vulnerability", "The security flaw itself is classified as the vulnerability."));
        questionBank.add(new Question(QuestionType.MCQ, "Why are Zero-Day attacks so dangerous?", new String[]{"They affect old OS only", "No security patches exist yet", "They only affect laptops", "They are easy to predict"}, "No security patches exist yet", "Defenses are unprepared because vendor patches are missing."));

        
        questionBank.add(new Question(QuestionType.MCQ, "Changing a prominent website's homepage to display unwanted images is called:", new String[]{"Defacement", "Doxing", "Phishing", "Spoofing"}, "Defacement", "Defacement modifies visual appearances of online properties."));
        questionBank.add(new Question(QuestionType.TRUE_FALSE, "Digital vandalism is always performed by state-sponsored intelligence groups.", null, "False", "It is often carried out by low-level script kiddies or hacktivists."));
        questionBank.add(new Question(QuestionType.FILL_IN_BLANK, "Frequent database ________ allow quick restoration after digital vandalism.", null, "Backups", "Backups enable webmasters to roll back defaced content quickly."));

        
        questionBank.add(new Question(QuestionType.TRUE_FALSE, "A Trojan horse virus can self-replicate without host files like a worm.", null, "False", "Trojans rely on users executing disguised files; they don't self-replicate."));
        questionBank.add(new Question(QuestionType.FILL_IN_BLANK, "Malware designed to gain system control while hiding its presence is a ________.", null, "Rootkit", "Rootkits modify deep OS functions to evade detection tools."));
        questionBank.add(new Question(QuestionType.MCQ, "Where do Rootkits typically plant themselves within an operating system?", new String[]{"Browser history", "Kernel level", "Desktop folder", "Trash bin"}, "Kernel level", "Kernel-level access allows rootkits to override default security rules."));
        questionBank.add(new Question(QuestionType.TRUE_FALSE, "A Trojan disguises itself as legitimate, harmless software.", null, "True", "Trojans trick users into installing them voluntarily."));
        questionBank.add(new Question(QuestionType.TRUE_FALSE, "Using the same weak password across multiple sites is safe.", null, "False", "Reusing passwords risks multi-account compromise via credential stuffing."));
        questionBank.add(new Question(QuestionType.MCQ, "Which protocol provides encrypted web traffic across sites?", new String[]{"HTTP", "HTTPS", "FTP", "SMTP"}, "HTTPS", "HTTPS uses SSL/TLS to encrypt web communications."));
    }

    
    static Color BG_COLOR      = new Color(10, 14, 46);
    static Color BUTTON_COLOR  = new Color(0, 180, 216);
    static Color PANEL_COLOR   = new Color(20, 25, 70);
    static Color CORRECT_COLOR = new Color(0, 200, 100);
    static Color WRONG_COLOR   = new Color(220, 50, 50);

    static JFrame frame;
    static int currentQuestionIndex = 0;
    static int score = 0;

    public static void main(String[] args) {
        initQuestions();
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("CyberSecurity Awareness App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(520, 680);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            showMainMenu();
            frame.setVisible(true);
        });
    }

    static JButton makeButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(BUTTON_COLOR);
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(280, 42));
        btn.setMaximumSize(new Dimension(320, 42));
        return btn;
    }

    static void setPanel(JPanel panel) {
        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }

    
    static void showMainMenu() {
        JPanel panel = new JPanel();
        panel.setBackground(BG_COLOR);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 40, 50, 40));

        JLabel title = new JLabel("CyberSecurity App");
        title.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 26));
        title.setForeground(BUTTON_COLOR);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Learn. Protect. Stay Safe.");
        subtitle.setFont(new Font("Bahnschrift Condensed", Font.ITALIC, 14));
        subtitle.setForeground(Color.LIGHT_GRAY);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton modulesBtn = makeButton("Modules");
        JButton quizBtn    = makeButton("Quiz (35 Questions)");
        JButton exitBtn    = makeButton("Exit");

        modulesBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        quizBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitBtn.setBackground(new Color(80, 80, 80));
        exitBtn.setForeground(Color.WHITE);

        modulesBtn.addActionListener(e -> showModulesMenu());
        quizBtn.addActionListener(e -> startQuiz());
        exitBtn.addActionListener(e -> System.exit(0));

        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 8)));
        panel.add(subtitle);
        panel.add(Box.createRigidArea(new Dimension(0, 50)));
        panel.add(modulesBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(quizBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(exitBtn);

        setPanel(panel);
    }

    
    static void showModulesMenu() {
        JPanel panel = new JPanel();
        panel.setBackground(BG_COLOR);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(BG_COLOR);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Security Modules");
        title.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 22));
        title.setForeground(BUTTON_COLOR);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        contentPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        contentPanel.add(title);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        for (int i = 0; i < moduleNames.length; i++) {
            final int index = i;
            JButton btn = makeButton(moduleNames[i]);
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.addActionListener(e -> showModuleDetail(index));
            contentPanel.add(btn);
            contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(12);

        JButton backBtn = makeButton("Back to Main Menu");
        backBtn.setBackground(new Color(80, 80, 80));
        backBtn.setForeground(Color.WHITE);
        backBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        backBtn.addActionListener(e -> showMainMenu());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(BG_COLOR);
        bottomPanel.add(backBtn);

        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        setPanel(panel);
    }

    static void showModuleDetail(int index) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BG_COLOR);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel title = new JLabel(moduleNames[index]);
        title.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 22));
        title.setForeground(BUTTON_COLOR);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        JTextArea textArea = new JTextArea(moduleDescriptions[index]);
        textArea.setFont(new Font("Bahnschrift Condensed", Font.PLAIN, 13));
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(PANEL_COLOR);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(BUTTON_COLOR, 1));

        JButton backBtn = makeButton("Back to Modules");
        backBtn.setBackground(new Color(80, 80, 80));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(e -> showModulesMenu());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(BG_COLOR);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        bottomPanel.add(backBtn);

        panel.add(title, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        setPanel(panel);
    }

    
    static void startQuiz() {
        currentQuestionIndex = 0;
        score = 0;
        showQuestion();
    }

    static void showQuestion() {
        if (currentQuestionIndex >= questionBank.size()) {
            showFinalScore();
            return;
        }

        Question q = questionBank.get(currentQuestionIndex);

        JPanel panel = new JPanel();
        panel.setBackground(BG_COLOR);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel qNum = new JLabel("Question " + (currentQuestionIndex + 1) + " of " + questionBank.size());
        qNum.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 13));
        qNum.setForeground(Color.LIGHT_GRAY);
        qNum.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setFont(new Font("Bahnschrift Condensed", Font.PLAIN, 12));
        scoreLabel.setForeground(BUTTON_COLOR);
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel qTypeLabel = new JLabel("[" + q.type.toString().replace("_", " ") + "]");
        qTypeLabel.setFont(new Font("Bahnschrift Condensed", Font.ITALIC, 11));
        qTypeLabel.setForeground(Color.YELLOW);
        qTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea qText = new JTextArea(q.questionText);
        qText.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 14));
        qText.setForeground(Color.WHITE);
        qText.setBackground(PANEL_COLOR);
        qText.setEditable(false);
        qText.setLineWrap(true);
        qText.setWrapStyleWord(true);
        qText.setAlignmentX(Component.CENTER_ALIGNMENT);
        qText.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        qText.setMaximumSize(new Dimension(420, 90));

        JLabel feedback = new JLabel(" ");
        feedback.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 12));
        feedback.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton nextBtn = makeButton(currentQuestionIndex + 1 == questionBank.size() ? "See Results" : "Next Question");
        nextBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        nextBtn.setVisible(false);
        nextBtn.addActionListener(e -> { currentQuestionIndex++; showQuestion(); });

        JPanel inputArea = new JPanel();
        inputArea.setBackground(BG_COLOR);
        inputArea.setLayout(new BoxLayout(inputArea, BoxLayout.Y_AXIS));

        if (q.type == QuestionType.TRUE_FALSE || q.type == QuestionType.MCQ) {
            ButtonGroup group = new ButtonGroup();
            List<JRadioButton> radioList = new ArrayList<>();

            for (String opt : q.options) {
                JRadioButton rb = new JRadioButton(opt);
                rb.setForeground(Color.WHITE);
                rb.setBackground(BG_COLOR);
                rb.setFont(new Font("Bahnschrift Condensed", Font.PLAIN, 13));
                rb.setAlignmentX(Component.CENTER_ALIGNMENT);
                group.add(rb);
                radioList.add(rb);
                inputArea.add(rb);
                inputArea.add(Box.createRigidArea(new Dimension(0, 5)));
            }

            JButton submitBtn = makeButton("Submit Answer");
            submitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
            submitBtn.addActionListener(e -> {
                String selected = "";
                for (JRadioButton rb : radioList) {
                    if (rb.isSelected()) selected = rb.getText();
                    rb.setEnabled(false);
                }
                submitBtn.setEnabled(false);

                if (selected.equalsIgnoreCase(q.correctAnswer)) {
                    score++;
                    feedback.setText("CORRECT! " + q.explanation);
                    feedback.setForeground(CORRECT_COLOR);
                } else {
                    feedback.setText("WRONG! Correct: " + q.correctAnswer + " - " + q.explanation);
                    feedback.setForeground(WRONG_COLOR);
                }
                nextBtn.setVisible(true);
                panel.revalidate(); panel.repaint();
            });

            inputArea.add(Box.createRigidArea(new Dimension(0, 10)));
            inputArea.add(submitBtn);

        } else if (q.type == QuestionType.FILL_IN_BLANK) {
            JTextField textField = new JTextField();
            textField.setMaximumSize(new Dimension(250, 30));
            textField.setFont(new Font("Bahnschrift Condensed", Font.PLAIN, 14));
            textField.setAlignmentX(Component.CENTER_ALIGNMENT);

            JButton submitBtn = makeButton("Submit Answer");
            submitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
            submitBtn.addActionListener(e -> {
                String userAns = textField.getText().trim();
                textField.setEnabled(false);
                submitBtn.setEnabled(false);

                if (userAns.equalsIgnoreCase(q.correctAnswer)) {
                    score++;
                    feedback.setText("CORRECT! " + q.explanation);
                    feedback.setForeground(CORRECT_COLOR);
                } else {
                    feedback.setText("WRONG! Correct: " + q.correctAnswer + " - " + q.explanation);
                    feedback.setForeground(WRONG_COLOR);
                }
                nextBtn.setVisible(true);
                panel.revalidate(); panel.repaint();
            });

            inputArea.add(textField);
            inputArea.add(Box.createRigidArea(new Dimension(0, 10)));
            inputArea.add(submitBtn);
        }

        panel.add(qNum);
        panel.add(Box.createRigidArea(new Dimension(0, 2)));
        panel.add(scoreLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 2)));
        panel.add(qTypeLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(qText);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(inputArea);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(feedback);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(nextBtn);

        setPanel(panel);
    }

    
    static void showFinalScore() {
        JPanel panel = new JPanel();
        panel.setBackground(BG_COLOR);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 40, 50, 40));

        JLabel title = new JLabel("Quiz Complete!");
        title.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 24));
        title.setForeground(BUTTON_COLOR);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel scoreLabel = new JLabel("Your Score: " + score + " / " + questionBank.size());
        scoreLabel.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 20));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        int percent = score * 100 / questionBank.size();
        JLabel percentLabel = new JLabel("Percentage: " + percent + "%");
        percentLabel.setFont(new Font("Bahnschrift Condensed", Font.PLAIN, 16));
        percentLabel.setForeground(Color.LIGHT_GRAY);
        percentLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        String msg;
        Color msgColor;
        if (percent >= 85) {
            msg = "Outstanding! You are a Cybersecurity Expert!";
            msgColor = CORRECT_COLOR;
        } else if (percent >= 50) {
            msg = "Good Job! Keep practicing the modules!";
            msgColor = BUTTON_COLOR;
        } else {
            msg = "Keep Practicing! Review the modules and try again.";
            msgColor = WRONG_COLOR;
        }

        JLabel msgLabel = new JLabel("<html><center>" + msg + "</center></html>");
        msgLabel.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 14));
        msgLabel.setForeground(msgColor);
        msgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        msgLabel.setMaximumSize(new Dimension(380, 60));

        JButton retryBtn = makeButton("Try Again");
        JButton menuBtn  = makeButton("Main Menu");
        retryBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuBtn.setBackground(new Color(80, 80, 80));
        menuBtn.setForeground(Color.WHITE);

        retryBtn.addActionListener(e -> startQuiz());
        menuBtn.addActionListener(e -> showMainMenu());

        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(scoreLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(percentLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(msgLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(retryBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(menuBtn);

        setPanel(panel);
    }
}