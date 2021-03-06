package com.codingforcookies.betterrecords.common.packets;

import com.codingforcookies.betterrecords.api.connection.RecordConnection;
import com.codingforcookies.betterrecords.api.wire.IRecordWire;
import com.codingforcookies.betterrecords.api.wire.IRecordWireHome;
import com.codingforcookies.betterrecords.common.core.helper.ConnectionHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class PacketWireConnection implements IPacket {
    private RecordConnection connection;

    public PacketWireConnection() { }

    public PacketWireConnection(RecordConnection connection) {
        this.connection = connection;
    }

    public void readBytes(ByteBuf bytes) {
        connection = new RecordConnection(ByteBufUtils.readUTF8String(bytes));
    }

    public void writeBytes(ByteBuf bytes) {
        ByteBufUtils.writeUTF8String(bytes, connection.toString());
    }

    public void executeClient(EntityPlayer player) { }

    public void executeServer(EntityPlayer player) {
        TileEntity te1 = player.world.getTileEntity(new net.minecraft.util.math.BlockPos(connection.x1, connection.y1, connection.z1));
        TileEntity te2 = player.world.getTileEntity(new BlockPos(connection.x2, connection.y2, connection.z2));
        if(te1 instanceof IRecordWire && te2 instanceof IRecordWire) {
            if(!(te1 instanceof IRecordWireHome && te2 instanceof IRecordWireHome)) {
                ConnectionHelper.addConnection(player.world, (IRecordWire)te1, connection, player.world.getBlockState(te1.getPos()));
                ConnectionHelper.addConnection(player.world, (IRecordWire)te1, connection, player.world.getBlockState(te1.getPos()));
                ConnectionHelper.addConnection(player.world, (IRecordWire)te2, connection, player.world.getBlockState(te2.getPos()));
            }
        }
    }
}
