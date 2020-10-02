package at.renerumetshofer.indymatic.entryPool;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import at.stnwtr.indymatic.config.Config;
import at.stnwtr.indymatic.config.InvalidConfigException;

/**
 * Pool of Indy activities parsed from a pool file. 
 * 
 * @author ReneRumetshofer
 * @since 02.10.2020
 */
public class ActivityPool {
	
	public static final int MAX_SEPARATORS = 1;
	private final Supplier<Stream<String>> lines;
	
	public ActivityPool(Path entryPoolFile) {		
		lines = () -> {
			try {
				return Files.readAllLines(entryPoolFile, StandardCharsets.UTF_8).stream()
					.filter(s -> !s.startsWith("#"))
					.filter(s -> s.chars().filter(value -> value == Config.TERMINATOR.charAt(0)).count() == MAX_SEPARATORS);
			} catch (IOException e) {
				throw new InvalidConfigException("Could not load the entry pool file! (' " + entryPoolFile.toFile().getAbsolutePath() + "')", e);
			}
		}; 
	}
	
	/**
	 * Parses read lines into activities.
	 * 
	 * @return Activities from the activity pool file.
	 */
	public List<Activity> getAllActivities() {
		return lines.get().map(s -> s.split(Config.TERMINATOR))
			.peek(strings -> {
				for (int i = 0; i < strings.length; i++) {
					strings[i] = strings[i].trim();
				}
			})
			.map(strings -> { return new Activity(strings[0], strings[1]); })
			.collect(Collectors.toCollection(LinkedList::new));
	}
	
}
