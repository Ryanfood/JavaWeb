package room.model.dto;

import java.util.Date;

import lombok.Data;
import room.model.po.Room;

@Data
public class BookingRoomDto {
	private Room room;
	private Integer userId;
	private Date checkinDate;
	private Date createTime;
	private Integer bookingId;
}
