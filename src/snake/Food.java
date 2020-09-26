package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public class Food extends Rect {
	private int eatenTimes;
	
	public Food(Snake snake, Rectangle drawingAea) {
		setColor(Color.GREEN);
		setDimension(new Dimension(Constants.FOOD_SIZE,Constants.FOOD_SIZE));
		setRandomLocation(snake, drawingAea);
	
	}
	
	public void setRandomLocation(Snake snake, Rectangle drawingAea) {
		int offset = 3;
		
		do {
			int minX = (int) drawingAea.getMinX() + offset;
			int minY = (int) drawingAea.getMinY() + offset;
		
			int maxX = (int) drawingAea.getMaxX() - Constants.FOOD_SIZE - offset;
			int maxY = (int) drawingAea.getMaxY() - Constants.FOOD_SIZE - offset;
		
			int randomX = GameUtils.random(minX, maxX);
			int randomY = GameUtils.random(minY, maxY);
		
			setLocation(new Point(randomX, randomY));
		} while (snake.intersects(this));
	}
	
	public void checIfEaten(Snake snake, Rectangle drawingAea) {
		if (snake.intersects(this)) {
			eatenTimes++;
			setRandomLocation(snake, drawingAea);
			snake.elongate();
		}
	}

	public int getEatenTimes() {
		// TODO Auto-generated method stub
		return eatenTimes;
	}
}
