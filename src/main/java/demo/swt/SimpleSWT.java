package demo.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SimpleSWT {
	
	public static void main(String[] args) {
		
		//创建Display,对应操作系统的控件，使用完必须释放 
		Display display = new Display();
		
		//创建shell
		Shell shell = new Shell(display);
		shell.setText("第一个shell窗口");
		
		//指定容器的布局类型
		GridLayout gl = new GridLayout(2,false);  
        shell.setLayout(gl);  
		
        //创建容器里的控件, 并指定摆放位置
        Label label1 = new Label(shell,SWT.NONE);  
        label1.setText("姓名");
        
        Font labelFont = new Font(display,"微软雅黑",20,SWT.NONE);
		
        Text text1 = new Text(shell,SWT.BORDER);  
        text1.setFont(labelFont);  
        text1.setLayoutData(new GridData(SWT.FILL,SWT.TOP,true,false));  
        
        shell.open();  
        while (!shell.isDisposed()) {  
            if (!display.readAndDispatch())  
                display.sleep();  
        }  
          
        display.dispose(); 
	}
}
