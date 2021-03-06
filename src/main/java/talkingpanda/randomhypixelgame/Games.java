package talkingpanda.randomhypixelgame;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
public class Games {
	public static File gamesf = new File("games.txt");
	public static int createGames() {
		try {
			 if (gamesf.createNewFile()) {
				 final String[] GAMESA = {"sb","warlords_ctf_mini","warlords_domination","warlords_team_deathmatch","mw_standard","mw_face_off","blitz_solo_normal","blitz_teams_normal","ranked_normal","solo_normal","solo_insane","teams_normal","teams_insane","solo_insane_rush","teams_insane_rush","solo_insane_slime","teams_insane_slime","tnt_tntrun","tnt_pvprun","tnt_bowspleef","tnt_tntag","tnt_capture","bedwars_eight_one","bedwars_eight_two","bedwars_four_three","bedwars_four_four","pit","arcade_hole_in_the_wall","arcade_soccer","arcade_bounty_hunters","arcade_pixel_painters","arcade_dragon_wars","arcade_ender_spleef","arcade_starwars","arcade_throw_out","arcade_party_games_1","arcade_farm_hunt","arcade_zombies_dead_end","arcade_zombies_bad_blood","arcade_zombies_alien_arcadium","arcade_hide_and_seek_prop_hunt","arcade_hide_and_seek_party_pooper","arcade_simon_says","arcade_santa_says","arcade_mini_walls","arcade_day_one","arcade_pvp_ctw","mcgo_normal","mcgo_deathmatch","mcgo_normal_party","mcgo_deathmatch_party","build_battle_solo_normal","build_battle_teams_normal","build_battle_solo_pro","build_battle_guess_the_build","uhc_solo","uhc_teams","vampirez","quake_solo","quake_teams","paintball","arena_1v1","arena_2v2","arena_4v4","walls","tkr","duels_classic_duel","duels_sw_duel","duels_sw_doubles","duels_bow_duel","duels_uhc_duel","duels_uhc_doubles","duels_uhc_four","duels_uhc_meetup","duels_potion_duel","duels_combo_duel","duels_potion_duel","duels_op_duel","duels_op_doubles","duels_mw_duel","duels_mw_doubles","duels_sumo_duel","duels_blitz_duel","duels_bowspleef_duel","duels_bridge_duel","duels_bridge_doubles","duels_bridge_four","duels_bridge_2v2v2v2","duels_bridge_3v3v3v3","speed_solo_normal","speed_team_normal","super_smash_solo_normal","super_smash_2v2_normal","super_smash_teams_normal","super_smash_1v1_normal","super_smash_friends_normal","murder_classic","murder_double_up","murder_assassins","murder_infection"};
					System.out.println("File created: " + gamesf.getAbsolutePath());
					FileWriter gameWriter = new FileWriter("games.txt");
					for(int i=0;i<GAMESA.length;i++){
						gameWriter.write(GAMESA[i]);
						gameWriter.write('\n');
					}
					RandomHypixelGame.gamesl = GAMESA;
					gameWriter.close();
					return 1;
			} else {
				return 0;
			}
		} catch (IOException e){
			System.out.println("An error occurred.");
			e.printStackTrace();
			return 0;
		}
	}
	public static void readGames() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("games.txt"));
			String str;
			List<String> list = new ArrayList<String>();
			while((str = in.readLine()) != null){
				list.add(str);
			}
			RandomHypixelGame.gamesl = list.toArray(new String[0]);
		} catch(Exception e) {

			e.printStackTrace();
		}
	}
	public static void resetGames(){
		try {
			if(gamesf.delete()){
				System.out.println("Deleted" + gamesf.toPath());
			}	
			createGames();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void addGames(String game){
		try {
			FileWriter gameWriter = new FileWriter("games.txt");
			gameWriter.write(game);
			gameWriter.write('\n');
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	public static void deleteGames(String game){
		try {
			if(gamesf.delete()){
					System.out.println("Deleted" + gamesf.toPath());
			}	
			FileWriter gameWriter = new FileWriter("games.txt");
			for(int i=0;i<RandomHypixelGame.gamesl.length;i++){
				String buf = RandomHypixelGame.gamesl[i];
				if(buf != game){
					gameWriter.write(buf);
					gameWriter.write('\n');
				}
			}
			gameWriter.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
