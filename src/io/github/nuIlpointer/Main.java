package io.github.nuIlpointer;

//スパゲッティコード、お許しください！
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
		getLogger().info("§6---------------------------------------");
		getLogger().info("§6nuIlpointer's System Utilization is §aenabled.");
		getLogger().info("§6---------------------------------------");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("§6----------------------------------------");
		getLogger().info("§6nuIlpointer's System Utilization is §4disabled.");
		getLogger().info("§6----------------------------------------");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("utilization")) {
			
			//MXBean
			OperatingSystemMXBean osMx = (OperatingSystemMXBean) 
				    ManagementFactory.getOperatingSystemMXBean();
			RuntimeMXBean runtimeMx = ManagementFactory.getRuntimeMXBean();
			
			//メモリの空き容量などを計算
			long total = Runtime.getRuntime().totalMemory() / 1048576; 
			long free = Runtime.getRuntime().freeMemory() / 1048576;
	        long used = total - free / 1048576;
	        long max = Runtime.getRuntime().maxMemory() / 1048576;
			String sat = new Date(runtimeMx.getStartTime()).toString();
			
			//出力
			sender.sendMessage("§6------------§f§n§l[System Utilization]§r§6------------");
			sender.sendMessage("§6物理メモリ: §f§l§n" + osMx.getTotalPhysicalMemorySize() / 1048576 + "§r§6 MB");
			sender.sendMessage("§6JVMが確保できる最大メモリ容量: §f§l§n" + max + "§r§6 MB" );
			sender.sendMessage("§6JVMが現在確保しているメモリ: §f§l§n" + total + "§r§6 MB");
			sender.sendMessage("§6メモリの空き容量: §f§l§n" + free + "§r§6 MB");
			sender.sendMessage("§6使用済みのメモリ: §f§l§n" + used + "§r§6 MB");
			sender.sendMessage("§6有効なプロセッサの数: §f§l§n" + osMx.getAvailableProcessors() + "§r§6 Cores");
			sender.sendMessage("§6CPU使用率: §f§l§n" + osMx.getSystemCpuLoad() * 100 + "§r§6 %");
			sender.sendMessage("§6JVM内のCPU使用率: §f§l§n" + osMx.getProcessCpuLoad() * 100 + "§r§6 %");
			sender.sendMessage("§6起動時間: §f§l§n" + runtimeMx.getUptime() + "§r§6 ms (起動された時間: §f§l§n" + sat + "§r§6 )");
			sender.sendMessage("§6----------------------------------------------------------");
		}
		
		return true;
	}
}
