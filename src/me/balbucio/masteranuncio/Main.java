package me.balbucio.masteranuncio;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.nio.file.Files;

public class Main extends Plugin {

	private File file = new File("plugins/balbMasterAnuncio", "config.yml");
	private Configuration configuration;

	@Override
	public void onEnable() {
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new Anuncio());
		ProxyServer.getInstance().getConsole().sendMessage(new TextComponent("[BalbucioMasterAnuncio] §2Ativado com sucesso!"));
	}

	@Override
	public void onLoad(){
		loadFiles();
	}

	private void loadFiles(){
		try {
			if (!file.exists()) {
				File folder = file.getParentFile();
				if (!folder.exists()) {
					folder.mkdir();
				}
				Files.copy(this.getResourceAsStream("config.yml"), file.toPath());
			}
			configuration = YamlConfiguration.getProvider(YamlConfiguration.class).load(file);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
