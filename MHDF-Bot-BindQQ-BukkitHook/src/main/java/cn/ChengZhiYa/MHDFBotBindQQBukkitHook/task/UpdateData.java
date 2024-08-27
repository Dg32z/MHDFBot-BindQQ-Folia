package cn.ChengZhiYa.MHDFBotBindQQBukkitHook.task;

import cn.ChengZhiYa.MHDFBotBindQQBukkitHook.main;
import cn.ChengZhiYa.MHDFBotBindQQBukkitHook.util.DatabaseUtil;
import com.github.Anon8281.universalScheduler.foliaScheduler.FoliaScheduler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public final class UpdateData {

    public void start() {
        new FoliaScheduler(main.instance).runTaskTimerAsynchronously(() -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                DatabaseUtil.updatePlayerData(player.getName());
                DatabaseUtil.updatePlayerVerify(player.getName());
                DatabaseUtil.updateDisableGroupHook(player.getName());
            }
        }, 0L, 20L);
    }
}

