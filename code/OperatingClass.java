package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class OperatingClass extends JFrame implements ActionListener {
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JPanel p1;

    JButton rock,paper,scissor;

    ImageIcon paperImg;
    ImageIcon rockImg;
    ImageIcon scissorImg;
    OperatingClass(){
        l1= new JLabel("Rock Paper Scissors!!  choose Your move: ");
        l1.setBounds(150,0,500,100);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(new Font("Algeria",Font.ITALIC,25));
        Container container= getContentPane();
        container.add(l1);

        l3= new JLabel("Computer made a move to ::");
        l3.setBounds(150,370,500,100);
        l3.setFont(new Font("Lato",Font.ITALIC,25));
        Container container2= getContentPane();
        container2.add(l3);

        paperImg= new ImageIcon("C:\\Users\\Binod Subedi\\Desktop\\rock paper scisors\\images\\paper.jpeg");
        Image im= paperImg.getImage();
        Image modim= im.getScaledInstance(150,150, Image.SCALE_SMOOTH);
        paperImg = new ImageIcon(modim);

        scissorImg= new ImageIcon("C:\\Users\\Binod Subedi\\Desktop\\rock paper scisors\\images\\scissor.jpg");
        Image im1= scissorImg.getImage();
        Image modim1= im1.getScaledInstance(150,150, Image.SCALE_SMOOTH);
        scissorImg = new ImageIcon(modim1);

        rockImg= new ImageIcon("C:\\Users\\Binod Subedi\\Desktop\\rock paper scisors\\images\\rock.jpg");
        Image im2= rockImg.getImage();
        Image modim2= im2.getScaledInstance(150,150, Image.SCALE_SMOOTH);
        rockImg = new ImageIcon(modim2);


        p1= new JPanel();
        p1.setBounds(150,150,470,150);
        p1.setLayout(new GridLayout(1,3,10,10));
        p1.setBorder(BorderFactory.createLineBorder(Color.darkGray,2));

        l2= new JLabel("V/S");
        l2.setFont(new Font("Algeria",Font.ITALIC,25));
        l2.setBounds(330,300,500,100);
        Container container3= getContentPane();
        container3.add(l2);

        l3= new JLabel();
        l3.setBounds(300,450,150,150);
        l3.setIcon(paperImg);
        l3.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,2));


        rock=new JButton();
        paper= new JButton();
        scissor = new JButton();

        rock.setIcon(rockImg);
        paper.setIcon(paperImg);
        scissor.setIcon(scissorImg);

        p1.add(rock);
        p1.add(paper);
        p1.add(scissor);

        rock.addActionListener(this);
        paper.addActionListener(this);
        scissor.addActionListener(this);


        this.add(p1);
        this.add(l3);
        this.setSize(750,750);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(255, 218, 185)));
        this.getContentPane().setBackground(new Color(112, 128, 144));
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        Random random= new Random();
        int rand= random.nextInt(4);
        switch (rand){
            case 1:
                l3.setIcon(rockImg);
                break;
            case 2:
                l3.setIcon(paperImg);
                break;
            case 3:
                l3.setIcon(scissorImg);
                break;

        }

        //1 = rock 2 = paper 3 = scissor


        if(e.getSource()==rock){


            if(rand== 1){
                this.dispose();
                JOptionPane.showMessageDialog(null,"you both choose rock!!! play again","deuce",JOptionPane.INFORMATION_MESSAGE);
                new OperatingClass();
            } else if (rand==2) {
                new Win();

            }
            else{
                new Lose();
            }

        }
        if(e.getSource()==paper){
            if(rand== 2){
                this.dispose();
                JOptionPane.showMessageDialog(null,"you both choose paper!!! play again","deuce",JOptionPane.INFORMATION_MESSAGE);
                new OperatingClass();
            }
            else if (rand==1) {
                new Win();

            }
            else{
                new Lose();
            }

        }
        if(e.getSource()==scissor){
            if(rand== 1){
                this.dispose();
                JOptionPane.showMessageDialog(null,"you both choose scissor!!! play again","deuce",JOptionPane.INFORMATION_MESSAGE);
                new OperatingClass();
            }
            else if (rand==2) {
                new Win();

            }
            else{
                new Lose();
            }


        }

    }
}

class Win{
    Win(){
        JOptionPane.showMessageDialog(null,"Congrats!!!!!!!!!! You Won","winner",JOptionPane.INFORMATION_MESSAGE);
    }
}
class Lose{
    Lose(){
        JOptionPane.showMessageDialog(null,"You Loose !!!! better luck next time","looser",JOptionPane.INFORMATION_MESSAGE);
    }
}