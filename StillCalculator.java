import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StillCalculator extends Application{
	boolean[] p = new boolean[4];
	double num1 , num2;
	
	public void start(Stage primaryStage){
		//create a pane
		Pane pane = new Pane();
		//create 28 action button by array
		Button bt[] = new Button[28];
		String btnIn[] = {"MC", "MR", "MS", "M+", "M-",
          "<-", "CE", "C", "±", "√", "7", "8", "9", "÷",
          "%", "4", "5", "6", "*", "1/x","1","2","3","-","=",
          "0",".","+"};
		//add the name in button
		for(int i = 0;i<28;++i){
			bt[i]=new Button(btnIn[i]);
		}
		//create a textfield to show caculate
		TextField t = new TextField();
		pane.getChildren().add(t);
      		t.setPrefSize(280, 70);
      		t.setLayoutX(10);
      		t.setLayoutY(30);
      		t.setEditable(false);
      		t.setText("0");
		
		//add the button in the pane
		for(int i = 0;i<28;++i){
			bt[i].setPrefSize(50, 60);
          		if(i<=4) {
              			bt[i].setLayoutX(10+60*i);
              			bt[i].setLayoutY(116);
              			pane.getChildren().add(bt[i]);
          		}
          		else if(i>4&&i<=9) {
        		 bt[i].setLayoutX(10+60*(i-5));
              		bt[i].setLayoutY(179);
              		pane.getChildren().add(bt[i]);
          		}
          		else if(i>9&&i<=14) {
              			bt[i].setLayoutX(10+60*(i-10));
              			bt[i].setLayoutY(242);
              			pane.getChildren().add(bt[i]);
          		}
          		else if(i>14&&i<=19) {
              			bt[i].setLayoutX(10+60*(i-15));
        			 bt[i].setLayoutY(305);
              			pane.getChildren().add(bt[i]);
          		}
          		else if(i>19&&i<=23) {
              			bt[i].setLayoutX(10+60*(i-20));
              			bt[i].setLayoutY(378);
              			pane.getChildren().add(bt[i]);
          		}
          		else if(i==24) {
              			bt[i].setLayoutX(10+60*(i-20));
              			bt[i].setLayoutY(378);
        			 bt[i].setPrefSize(50, 120);
              			pane.getChildren().add(bt[i]);
          		}
          		else if(i==25) {
              			bt[i].setLayoutX(10+60*(i-25));
              			bt[i].setLayoutY(441);
              			bt[i].setPrefSize(110, 60);
              			pane.getChildren().add(bt[i]);
          		}
          		else {
              			bt[i].setLayoutX(10+60*(i-24));
              			bt[i].setLayoutY(441);
              			pane.getChildren().add(bt[i]);
          		}  
      		}
		//create menubar
		MenuBar bar = new MenuBar();
		//create three menus
		Menu menu1 = new Menu("檢視(V)");
		Menu menu2 = new Menu("編輯(E)");
		Menu menu3 = new Menu("說明(H)");
		//create three menu item for each menu
		MenuItem item1[] = new MenuItem[10];
		MenuItem item2[] = new MenuItem[3];
		MenuItem item3[] = new MenuItem[2];
		String item1Name[] = {"標準型(T)","工程型(S)","程式設計師(P)","統計資料(A)",
      "歷程紀錄(Y)","數字分位(I)","基本(B)","單位換算(U)","日期計算(D)","工作表(W)"};
		String item2Name[] = {"複製(C)","貼上(P)","歷程紀錄(H)"};
		String item3Name[] = {"檢視說明(V)    F1","關於小算盤(A)"};
		//add the item in responce menu
		for(int i = 0;i<10;++i){
			item1[i] = new MenuItem(item1Name[i]);
          		menu1.getItems().add(item1[i]);
		}
		for(int i = 0;i<3;++i){
			item2[i] = new MenuItem(item2Name[i]);
          		menu2.getItems().add(item2[i]);
		}
		for(int i = 0;i<2;++i){
			item3[i] = new MenuItem(item3Name[i]);
          		menu3.getItems().add(item3[i]);
		}
		//add the menus in menubar and add in the pane
		bar.getMenus().addAll(menu1,menu2,menu3);
		bar.setLayoutX(10);
		pane.getChildren().add(bar);
	
		//create the scene and add the pane
		Scene scene = new Scene(pane,300,500);
		primaryStage.setResizable(false);
      		primaryStage.setTitle("U10416031's caculator");
      		primaryStage.setScene(scene);
      		primaryStage.show();
      
      		//The number buttons action
      		bt[10].setOnAction(e -> {
			t.setText(t.getText() + "7");
		});
		bt[11].setOnAction(e ->{
			t.setText(t.getText() + "8");
		});
		bt[12].setOnAction(e -> {
			t.setText(t.getText() + "9");
		});
		
		bt[15].setOnAction(e -> {
			t.setText(t.getText() + "4");
		});
		bt[16].setOnAction(e ->{
			t.setText(t.getText() + "5");
		});
		bt[17].setOnAction(e -> {
			t.setText(t.getText() + "6");
		});
		
		bt[20].setOnAction(e -> {
			t.setText(t.getText() + "1");
		});
		bt[21].setOnAction(e ->{
			t.setText(t.getText() + "2");
		});
		bt[22].setOnAction(e -> {
			t.setText(t.getText() + "3");
		});
		
		bt[25].setOnAction(e -> {
			t.setText(t.getText() + "0");
		});
		
		//delete all the number 
		bt[7].setOnAction(e -> {
			t.clear();
		});
		
		//button delete 
		bt[5].setOnAction(e -> {
			String s;
			s = t.getText();
			String s2 = s.substring(0, (s.length()-1));
			t.setText(s2);
		});
		//button point(.)
		bt[26].setOnAction(e -> {
			
			t.setText(t.getText() + ".");
		});
		
		//plus
		bt[13].setOnAction(e -> {
			
			num1 = Double.parseDouble(t.getText());
			t.clear();
			
			p[0] =true;
			p[1] = false;
			p[2] = false;
			p[3] = false;
			
		});
		
		// "-" 
		bt[18].setOnAction(e -> {
			
			num1 = Double.parseDouble(t.getText());
			t.clear();
			
			p[0] = false;
			p[1] = true;
			p[2] = false;
			p[3] = false;
			
		});
		
		// *
		bt[23].setOnAction(e -> {
			
			num1 = Double.parseDouble(t.getText());
			t.clear();
			
			p[0] = false;
			p[1] = false;
			p[2] = true;
			p[3] = false;
			
		});
		
		// "/"
		bt[27].setOnAction(e -> {
			
			num1 = Double.parseDouble(t.getText());
			t.clear();
			
			p[0] = false;
			p[1] = false;
			p[2] = false;
			p[3] = true;
			
		});
		
		//button " = "
		bt[24].setOnAction(e -> {
			
			num2 = Double.parseDouble(t.getText());
			
			if(p[0] == true){
				 num1 = num1 + num2;
				 t.setText(Double.toString(num1));
			}
			
			else if (p[1] == true){
				num1 = num1 - num2;
				t.setText(Double.toString(num1));
			}
			else if (p[2] == true){
				num1 = num1 * num2;
				t.setText(Double.toString(num1));
			}
			else if (p[3] == true){
				num1 = num1 / num2;
				t.setText(Double.toString(num1));
			}
			
		});
	}
    
      
}      
