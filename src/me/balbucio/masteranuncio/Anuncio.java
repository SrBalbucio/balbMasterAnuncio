package me.balbucio.masteranuncio;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Anuncio extends Command {
	public Anuncio() {
		super("manuncio");
	}

	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof ProxiedPlayer)){ sender.sendMessage("§cÉ necessário ser um player para usar esse comando!"); return; }
		if (sender.hasPermission("manuncio.use")) {
			if (args.length == 0) {
				sender.sendMessage("§abalbMasterAnuncio §f- §eAtivo!");
				sender.sendMessage("§cUse /manuncio criar para criar um anúncio.");
				return;
			}
			ProxiedPlayer player = (ProxiedPlayer) sender;
			String arg = args[0];
			if (arg.equalsIgnoreCase("criar")) {
				String message = null;
				for (int i = 1; i < args.length; i++) {
					if(message == null){
						message = args[i];
					} else {
						message += " " + args[i];
					}
				}
				for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
					all.sendMessage(new TextComponent(""));
					all.sendMessage(new TextComponent(" §6" + player.getDisplayName() + " §a> §e" + message));
					all.sendMessage(new TextComponent(""));
				}
			} else if (arg.equalsIgnoreCase("preview")) {
				String message = null;
				for (int i = 1; i < args.length; i++) {
					if(message == null){
						message = args[i];
					} else {
						message += " " + args[i];
					}
				}
				sender.sendMessage(new TextComponent(""));
				sender.sendMessage(new TextComponent(" §6" + player.getDisplayName() + " §a> §e" + message));
				sender.sendMessage(new TextComponent(""));
			} else if (arg.equalsIgnoreCase("help")) {
				sender.sendMessage(new TextComponent("§abalbMasterAnuncio §7- Comandos:"));
				sender.sendMessage(new TextComponent("§bmanuncio criar §7- Cria um anúncio"));
				sender.sendMessage(new TextComponent("§bmanuncio preview §7- Visualiza a forma final de um anúncio"));
				sender.sendMessage(new TextComponent("§bmanuncio help §7- Mostra essa mensagem"));
			} else {
				sender.sendMessage("§cComando não reconhecido!");
			}
		}
	}
}
