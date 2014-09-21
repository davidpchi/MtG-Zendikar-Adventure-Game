
public class RenderCamera {

	int x;
	int y;
	int width;
	int height;
	int renderEdge;
	int followSpeed;
	
	public RenderCamera(int x, int y, int width, int height, int renderEdge, int followSpeed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.renderEdge = renderEdge;
		this.followSpeed = followSpeed;
	}
	
	public RenderCamera(int x, int y, int width, int height) {
		this(x, y, width, height, 200, 5);
	}
}
