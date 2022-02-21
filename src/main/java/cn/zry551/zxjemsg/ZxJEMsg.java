package cn.zry551.zxjemsg;

import cn.zry551.zxjemsg.Event.PlayerExit;
import cn.zry551.zxjemsg.Event.PlayerLogin;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.logging.Logger;

public final class ZxJEMsg extends JavaPlugin {
    public static JavaPlugin SelfClass;
    public static FileConfiguration Cfg;
    public static String DataPath;
    public static File DataFile;
    public static File CfgFile;
    public static Logger Log;
    @Override
    public void onLoad() {
        // Plugin load logic
        SelfClass = this;
        Cfg = this.getConfig();
        DataPath = this.getDataFolder().getPath();
        DataFile = this.getDataFolder();
        Log = getLogger();
        CfgFile = new File(DataPath + "/Config.yml");
        Log.warning("Starting ! ");
        // 初始化代码
        // 下面的代码初始化配置文件
        try{
            // 使用Try包裹处理异常
            if(!DataFile.exists()){
                Log.warning("Data Dir Not Found ! Make It ! ");
                DataFile.mkdir();
            }
            if(!CfgFile.exists()){
                Log.warning("Config File Not Found ! Make It and Write Default Data ! ");
                CfgFile.createNewFile();
                BufferedWriter W = new BufferedWriter(new FileWriter(CfgFile,true));
                //读取Jar内容并写入到文件
                BufferedReader RIN = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("res/default.yml")));
                StringBuilder Builder = new StringBuilder();
                String lines = "";
                while ((lines = RIN.readLine()) != null){
                    Builder.append(lines + "\n");
                }
                W.write(Builder.toString());
                W.close();

            }
            Log.info("Load Config ! ");
            Cfg.load(DataPath + "/Config.yml");
            Data.JoinFormat = Cfg.getString("JoinFormat");
            Data.QuitFormat = Cfg.getString("QuitFormat");
            Data.Use = Cfg.getBoolean("Use");


        }catch (Exception ex){
            ex.printStackTrace();
            Log.warning("Load Error ! Can't Load this plugin ! ");

        }


    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new PlayerLogin(), this);
        Log.warning("Register event : PlayerJoin ! ");
        Bukkit.getPluginManager().registerEvents(new PlayerExit(), this);
        Log.warning("Register event : PlayerQuit ! ");
        Log.warning("Register event finish ! Start Work ! ");


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
