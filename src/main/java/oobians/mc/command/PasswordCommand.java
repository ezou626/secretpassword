package oobians.mc.command;

import oobians.mc.SecretPassword;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

import static com.mojang.brigadier.arguments.StringArgumentType.greedyString;
import static net.minecraft.commands.Commands.argument;
import static net.minecraft.commands.Commands.literal;

public class PasswordCommand {
    public static final PasswordCommand INSTANCE = new PasswordCommand();

    public static final String[] ALIASES = { "password", "pw", "pwd", "pass", "login" };

    public void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext commandBuildContext,
            Commands.CommandSelection commandSelection) {
        for (String alias : ALIASES) {
            dispatcher.register(literal(alias)
                    .then(argument("password", greedyString())
                            .executes(context -> SecretPassword.tryLogin(context.getSource().getPlayerOrException(),
                                    com.mojang.brigadier.arguments.StringArgumentType.getString(context,
                                            "password")))));
        }
    }

}