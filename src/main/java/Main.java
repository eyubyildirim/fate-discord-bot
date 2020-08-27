import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.event.domain.message.ReactionAddEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.object.reaction.ReactionEmoji;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private static final String CLIENT_TOKEN = "Client token buraya";
    private static final String CLIENT_ID = "Client ID buraya";

    private static DiceRoll diceRoll = DiceRoll.getInstance();

    private static final ArrayList<ReactionEmoji> rollDiceEmojis = new ArrayList<>();

    public static void main(String[] args) {
        final DiscordClient client = DiscordClient.create(CLIENT_TOKEN);
        final GatewayDiscordClient gateway = client.login().block();
        initializeReactionList();

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();

            if ("!diceroll".equals(message.getContent())) {
                final MessageChannel channel = message.getChannel().block();

                diceRoll = rollDice(0);

                Message embed = channel.createEmbed(embedCreateSpec -> {
                    embedCreateSpec.addField("Rolled Dice",
                            diceRoll.toString() + " + " + 0 + " = " + diceRoll.getDiceSum(),
                            true);
                }).block();

                for (ReactionEmoji emoji : rollDiceEmojis) {
                    embed.addReaction(emoji).block();
                }
            }
        });

        gateway.on(ReactionAddEvent.class).subscribe(reactionAddEvent -> {
            Message message = reactionAddEvent.getMessage().block();
            User user = reactionAddEvent.getUser().block();

            if (!isBot(user.getId().asString()) && !isBot(reactionAddEvent.getMessageId().asString())) {
                if (rollDiceEmojis.contains(reactionAddEvent.getEmoji())) {
                    message.removeReaction(reactionAddEvent.getEmoji(), user.getId()).block();
                    int plus = rollDiceEmojis.indexOf(reactionAddEvent.getEmoji());
                    diceRoll = rollDice(plus);

                    message.edit(messageEditSpec -> {
                        messageEditSpec.setEmbed(embedCreateSpec -> {
                            embedCreateSpec.addField("Rolled Dice",
                                    diceRoll.toString() + " + " + plus + " = " + diceRoll.getDiceSum(),
                                    true);
                        });
                    }).block();
                }
            }

        });

        gateway.onDisconnect().block();
    }

    public static boolean isBot(String clientId) {
        return clientId.equals(CLIENT_ID);
    }

    private static void initializeReactionList() {
        rollDiceEmojis.add(ReactionEmoji.unicode("0️⃣"));
        rollDiceEmojis.add(ReactionEmoji.unicode("1️⃣"));
        rollDiceEmojis.add(ReactionEmoji.unicode("2️⃣"));
        rollDiceEmojis.add(ReactionEmoji.unicode("3️⃣"));
        rollDiceEmojis.add(ReactionEmoji.unicode("4️⃣"));
        rollDiceEmojis.add(ReactionEmoji.unicode("5️⃣"));
        rollDiceEmojis.add(ReactionEmoji.unicode("6️⃣"));
        rollDiceEmojis.add(ReactionEmoji.unicode("7️⃣"));
        rollDiceEmojis.add(ReactionEmoji.unicode("8️⃣"));
    }

    public static DiceRoll rollDice(int plus) {
        return diceRoll.rollDice(plus);
    }

}
