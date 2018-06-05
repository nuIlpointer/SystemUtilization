package io.github.nuIlpointer;

//�X�p�Q�b�e�B�R�[�h�A���������������I
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.util.Date;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getLogger().info("��6---------------------------------------");
		getLogger().info("��6nuIlpointer's System Utilization is ��aenabled.");
		getLogger().info("��6---------------------------------------");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("��6----------------------------------------");
		getLogger().info("��6nuIlpointer's System Utilization is ��4disabled.");
		getLogger().info("��6----------------------------------------");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("utilization")) {
			
			//MXBean
			OperatingSystemMXBean osMx = (OperatingSystemMXBean) 
				    ManagementFactory.getOperatingSystemMXBean();
			RuntimeMXBean runtimeMx = ManagementFactory.getRuntimeMXBean();
			
			//�������̋󂫗e�ʂȂǂ��v�Z
			long total = Runtime.getRuntime().totalMemory() / 1048576; 
			long free = Runtime.getRuntime().freeMemory() / 1048576;
	        long used = total - free / 1048576;
	        long max = Runtime.getRuntime().maxMemory() / 1048576;
			String sat = new Date(runtimeMx.getStartTime()).toString();
			
			//�o��
			sender.sendMessage("��6------------��f��n��l[System Utilization]��r��6------------");
			sender.sendMessage("��6����������: ��f��l��n" + osMx.getTotalPhysicalMemorySize() / 1048576 + "��r��6 MB");
			sender.sendMessage("��6JVM���m�ۂł���ł���ő僁�����e��: ��f��l��n" + max + "��r��6 MB" );
			sender.sendMessage("��6JVM�����݊m�ۂ��Ă��郁����: ��f��l��n" + total + "��r��6 MB");
			sender.sendMessage("��6�������̋󂫗e��: ��f��l��n" + free + "��r��6 MB");
			sender.sendMessage("��6�g�p�ς݂̃�����: ��f��l��n" + used + "��r��6 MB");
			sender.sendMessage("��6�L���ȃv���Z�b�T�̐�: ��f��l��n" + osMx.getAvailableProcessors() + "��r��6 Cores");
			sender.sendMessage("��6CPU�g�p��: ��f��l��n" + osMx.getSystemCpuLoad() * 100 + "��r��6 %");
			sender.sendMessage("��6JVM����CPU�g�p��: ��f��l��n" + osMx.getProcessCpuLoad() * 100 + "��r��6 %");
			sender.sendMessage("��6�N������: ��f��l��n" + runtimeMx.getUptime() + "��r��6 ms (�N�����ꂽ����: ��f��l��n" + sat + "��r��6 )");
			sender.sendMessage("��6----------------------------------------------------------");
		}
		
		return true;
	}
}
