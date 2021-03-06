package ru.gravit.launchserver.response.auth;

import ru.gravit.launcher.serialize.HInput;
import ru.gravit.launcher.serialize.HOutput;
import ru.gravit.launchserver.LaunchServer;
import ru.gravit.launchserver.response.Response;

public class ChangeServerResponse extends Response {
    public static boolean needChange = false;
    public static String address;
    public static int port;

    public ChangeServerResponse(LaunchServer server, long session, HInput input, HOutput output, String ip) {
        super(server, session, input, output, ip);
    }

    @Override
    public void reply() throws Exception {
        writeNoError(output);
        output.writeBoolean(needChange);
        //if true
        if (needChange) {
            output.writeString(address, 255);
            output.writeInt(port);
        }
    }
}
