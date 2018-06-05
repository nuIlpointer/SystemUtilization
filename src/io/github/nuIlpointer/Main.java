package io.github.nuIlpointer;

//ã‚¹ãƒ‘ã‚²ãƒƒãƒ†ã‚£ã‚³ãƒ¼ãƒ‰ã€ãŠè¨±ã—ãã ã•ã„ï¼
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
<<<<<<< HEAD
		getLogger().info(ChatColor.GOLD + "---------------------------------------");
		getLogger().info(ChatColor.GOLD + "nuIlpointer's System Utilization is " + ChatColor.GREEN + "enabled.");
		getLogger().info(ChatColor.GOLD + "---------------------------------------");
=======
		getLogger().info("Â§6---------------------------------------");
		getLogger().info("Â§6nuIlpointer's System Utilization is Â§aenabled.");
		getLogger().info("Â§6---------------------------------------");
>>>>>>> f5720fabd2900a336fe2f8152e956454cc197a4e
	}
	
	@Override
	public void onDisable() {
<<<<<<< HEAD
		getLogger().info(ChatColor.GOLD + "----------------------------------------");
		getLogger().info(ChatColor.GOLD + "nuIlpointer's System Utilization is " + ChatColor.DARK_RED + "disabled.");
		getLogger().info(ChatColor.GOLD + "----------------------------------------");
=======
		getLogger().info("Â§6----------------------------------------");
		getLogger().info("Â§6nuIlpointer's System Utilization is Â§4disabled.");
		getLogger().info("Â§6----------------------------------------");
>>>>>>> f5720fabd2900a336fe2f8152e956454cc197a4e
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("utilization")) {
			
			//MXBean
			OperatingSystemMXBean osMx = (OperatingSystemMXBean) 
				    ManagementFactory.getOperatingSystemMXBean();
			RuntimeMXBean runtimeMx = ManagementFactory.getRuntimeMXBean();
			
			//ãƒ¡ãƒ¢ãƒªã®ç©ºãå®¹é‡ãªã©ã‚’è¨ˆç®—
			long total = Runtime.getRuntime().totalMemory() / 1048576; 
			long free = Runtime.getRuntime().freeMemory() / 1048576;
	        long used = total - free / 1048576;
	        long max = Runtime.getRuntime().maxMemory() / 1048576;
			String sat = new Date(runtimeMx.getStartTime()).toString();
			
<<<<<<< HEAD
			//o—Í
			sender.sendMessage("˜6------------˜f˜n˜l[System Utilization]˜r˜6------------");
			sender.sendMessage("˜6•¨—ƒƒ‚ƒŠ: ˜f˜l˜n" + osMx.getTotalPhysicalMemorySize() / 1048576 + "˜r˜6 MB");
			sender.sendMessage("˜6JVM‚ªŠm•Û‚Å‚«‚éÅ‘åƒƒ‚ƒŠ—e—Ê: ˜f˜l˜n" + max + "˜r˜6 MB" );
			sender.sendMessage("˜6JVM‚ªŒ»İŠm•Û‚µ‚Ä‚¢‚éƒƒ‚ƒŠ: ˜f˜l˜n" + total + "˜r˜6 MB");
			sender.sendMessage("˜6ƒƒ‚ƒŠ‚Ì‹ó‚«—e—Ê: ˜f˜l˜n" + free + "˜r˜6 MB");
			sender.sendMessage("˜6g—pÏ‚İ‚Ìƒƒ‚ƒŠ: ˜f˜l˜n" + used + "˜r˜6 MB");
			sender.sendMessage("˜6—LŒø‚ÈƒvƒƒZƒbƒT‚Ì”: ˜f˜l˜n" + osMx.getAvailableProcessors() + "˜r˜6 Cores");
			sender.sendMessage("˜6CPUg—p—¦: ˜f˜l˜n" + osMx.getSystemCpuLoad() * 100 + "˜r˜6 %");
			sender.sendMessage("˜6JVM“à‚ÌCPUg—p—¦: ˜f˜l˜n" + osMx.getProcessCpuLoad() * 100 + "˜r˜6 %");
			sender.sendMessage("˜6‹N“®ŠÔ: ˜f˜l˜n" + runtimeMx.getUptime() + "˜r˜6 ms (‹N“®‚³‚ê‚½ŠÔ: ˜f˜l˜n" + sat + "˜r˜6 )");
			sender.sendMessage("˜6----------------------------------------------------------");
=======
			//å‡ºåŠ›
			sender.sendMessage("Â§6------------Â§fÂ§nÂ§l[System Utilization]Â§rÂ§6------------");
			sender.sendMessage("Â§6ç‰©ç†ãƒ¡ãƒ¢ãƒª: Â§fÂ§lÂ§n" + osMx.getTotalPhysicalMemorySize() / 1048576 + "Â§rÂ§6 MB");
			sender.sendMessage("Â§6JVMãŒç¢ºä¿ã§ãã‚‹æœ€å¤§ãƒ¡ãƒ¢ãƒªå®¹é‡: Â§fÂ§lÂ§n" + max + "Â§rÂ§6 MB" );
			sender.sendMessage("Â§6JVMãŒç¾åœ¨ç¢ºä¿ã—ã¦ã„ã‚‹ãƒ¡ãƒ¢ãƒª: Â§fÂ§lÂ§n" + total + "Â§rÂ§6 MB");
			sender.sendMessage("Â§6ãƒ¡ãƒ¢ãƒªã®ç©ºãå®¹é‡: Â§fÂ§lÂ§n" + free + "Â§rÂ§6 MB");
			sender.sendMessage("Â§6ä½¿ç”¨æ¸ˆã¿ã®ãƒ¡ãƒ¢ãƒª: Â§fÂ§lÂ§n" + used + "Â§rÂ§6 MB");
			sender.sendMessage("Â§6æœ‰åŠ¹ãªãƒ—ãƒ­ã‚»ãƒƒã‚µã®æ•°: Â§fÂ§lÂ§n" + osMx.getAvailableProcessors() + "Â§rÂ§6 Cores");
			sender.sendMessage("Â§6CPUä½¿ç”¨ç‡: Â§fÂ§lÂ§n" + osMx.getSystemCpuLoad() * 100 + "Â§rÂ§6 %");
			sender.sendMessage("Â§6JVMå†…ã®CPUä½¿ç”¨ç‡: Â§fÂ§lÂ§n" + osMx.getProcessCpuLoad() * 100 + "Â§rÂ§6 %");
			sender.sendMessage("Â§6èµ·å‹•æ™‚é–“: Â§fÂ§lÂ§n" + runtimeMx.getUptime() + "Â§rÂ§6 ms (èµ·å‹•ã•ã‚ŒãŸæ™‚é–“: Â§fÂ§lÂ§n" + sat + "Â§rÂ§6 )");
			sender.sendMessage("Â§6----------------------------------------------------------");
>>>>>>> f5720fabd2900a336fe2f8152e956454cc197a4e
		}
		
		return true;
	}
}
