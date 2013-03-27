package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

import bent.Area;
import bent.Wall;

import model.Monsters;
import model.PlayerChar;


public class Board extends JPanel { 

    private final int OFFSET = 30;
    private final int SPACE = 20;
    private final int LEFT_COLLISION = 1;
    private final int RIGHT_COLLISION = 2;
    private final int TOP_COLLISION = 3;
    private final int BOTTOM_COLLISION = 4;

    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private ArrayList<Monsters> mobs = new ArrayList<Monsters>();
    private ArrayList<Area> areas = new ArrayList<Area>();
    private PlayerChar karakter;
    
    private int w = 21;
    private int h = 9;
    private boolean completed = false;
    
    private String level =
              "#####################\n" +
              "#                   #\n" +
              "#                   #\n" +
              "# @                 #\n" +
              "#             $     #\n" +
              "#                   #\n" +
              "#                   #\n" +
              "#                   #\n" +
              "#####################\n";
              

    public Board() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        initWorld();
    }

    public int getBoardWidth() {
        return this.w;
    }

    public int getBoardHeight() {
        return this.h;
    }

    public final void initWorld() {

    	 Wall wall;
         Monsters b;
         Area a;

        int x = OFFSET;
        int y = OFFSET;
        
        for (int i = 0; i < level.length(); i++) {

            char item = level.charAt(i);

            if (item == '\n') {
                y += SPACE;
                if (this.w < x) {
                    this.w = x;
                }

                x = OFFSET;
            } else if (item == '#') {
                wall = new Wall(x, y);
                walls.add(wall);
                x += SPACE;
            } else if (item == '$') {
                b = new Monsters(x, y);
                mobs.add(b);
                x += SPACE;
            } else if (item == '.') {
                a = new Area(x, y);
                areas.add(a);
                x += SPACE;
            } else if (item == '@') {
                karakter = new PlayerChar(x, y);
                x += SPACE;
            } else if (item == ' ') {
                x += SPACE;
            }

            h = y;
        }
    }

    public void buildWorld(Graphics g) {

        g.setColor(new Color(250, 240, 170));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        ArrayList<Object> world = new ArrayList<Object>();
        world.addAll(walls);
        world.addAll(areas);
        world.addAll(mobs);
        world.add(karakter);

        for (int i = 0; i < world.size(); i++) {

//            PlayerChar item = (PlayerChar) world.get(i);
//
//            if ((item instanceof )
//                    || (item instanceof Monsters)) {
//                g.drawImage(item.getImage(), item.posx() + 2, item.posy() + 2, this);
//            } else {
//                g.drawImage(item.getImage(), item.posx(), item.posy(), this);
//            }

            if (completed) {
                g.setColor(new Color(0, 0, 0));
                g.drawString("Completed", 25, 20);
            }

        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buildWorld(g);
    }

    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            if (completed) {
                return;
            }

            
            int key = e.getKeyCode();


            if (key == KeyEvent.VK_LEFT) {
                if (checkWallCollision(karakter,
                        LEFT_COLLISION)) {
                    return;
                }

//                if (checkMonsterCollision(LEFT_COLLISION)) {
//                    return;
//                }

                karakter.move(-SPACE, 0);

            } else if (key == KeyEvent.VK_RIGHT) {

                if (checkWallCollision(karakter,
                        RIGHT_COLLISION)) {
                    return;
                }

//                if (checkMonsterCollision(RIGHT_COLLISION)) {
//                    return;
//                }

                karakter.move(SPACE, 0);

            } else if (key == KeyEvent.VK_UP) {

                if (checkWallCollision(karakter,
                        TOP_COLLISION)) {
                    return;
                }

//                if (checkMonsterCollision(TOP_COLLISION)) {
//                    return;
//                }

                karakter.move(0, -SPACE);

            } else if (key == KeyEvent.VK_DOWN) {

                if (checkWallCollision(karakter,
                        BOTTOM_COLLISION)) {
                    return;
                }

//                if (checkMonsterCollision(BOTTOM_COLLISION)) {
//                    return;
//                }

                karakter.move(0, SPACE);

//            } else if (key == KeyEvent.VK_R) {
//                restartLevel();
//            }
            }

            repaint();
        }
    }

    private boolean checkWallCollision(PlayerChar actor, int type) {

        if (type == LEFT_COLLISION) {

            for (int i = 0; i < walls.size(); i++) {
                Wall wall = (Wall) walls.get(i);
                if (actor.isLeftCollision(wall)) {
                    return true;
                }
            }
            return false;

        } else if (type == RIGHT_COLLISION) {

            for (int i = 0; i < walls.size(); i++) {
                Wall wall = (Wall) walls.get(i);
                if (actor.isRightCollision(wall)) {
                    return true;
                }
            }
            return false;

        } else if (type == TOP_COLLISION) {

            for (int i = 0; i < walls.size(); i++) {
                Wall wall = (Wall) walls.get(i);
                if (actor.isTopCollision(wall)) {
                    return true;
                }
            }
            return false;

        } else if (type == BOTTOM_COLLISION) {

            for (int i = 0; i < walls.size(); i++) {
                Wall wall = (Wall) walls.get(i);
                if (actor.isBottomCollision(wall)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

//    private boolean checkMonsterCollision(int type) {
//
//        if (type == LEFT_COLLISION) {
//
//            for (int i = 0; i < mobs.size(); i++) {
//
//                Monsters bag = (Monsters) mobs.get(i);
//                if (karakter.isLeftCollision(bag)) {
//
//                    for (int j=0; j < mobs.size(); j++) {
//                        Monsters item = (Monsters) mobs.get(j);
//                        if (!bag.equals(item)) {
//                            if (bag.isLeftCollision(item)) {
//                                return true;
//                            }
//                        }
//                        if (checkWallCollision(bag,
//                                LEFT_COLLISION)) {
//                            return true;
//                        }
//                    }
//                    bag.move(-SPACE, 0);
//                }
//            }
//            return false;
//
//        } else if (type == RIGHT_COLLISION) {
//
//            for (int i = 0; i < mobs.size(); i++) {
//
//                Monsters bag = (Monsters) mobs.get(i);
//                if (karakter.isRightCollision(bag)) {
//                    for (int j=0; j < mobs.size(); j++) {
//
//                        Monsters item = (Monsters) mobs.get(j);
//                        if (!bag.equals(item)) {
//                            if (bag.isRightCollision(item)) {
//                                return true;
//                            }
//                        }
//                        if (checkWallCollision(bag,
//                                RIGHT_COLLISION)) {
//                            return true;
//                        }
//                    }
//                    bag.move(SPACE, 0);
//                }
//            }
//            return false;
//
//        } else if (type == TOP_COLLISION) {
//
//            for (int i = 0; i < mobs.size(); i++) {
//
//                Monsters bag = (Monsters) mobs.get(i);
//                if (karakter.isTopCollision(bag)) {
//                    for (int j = 0; j < mobs.size(); j++) {
//
//                        Monsters item = (Monsters) mobs.get(j);
//                        if (!bag.equals(item)) {
//                            if (bag.isTopCollision(item)) {
//                                return true;
//                            }
//                        }
//                        if (checkWallCollision(bag,
//                                TOP_COLLISION)) {
//                            return true;
//                        }
//                    }
//                    bag.move(0, -SPACE);
//                }
//            }
//
//            return false;
//
//        } else if (type == BOTTOM_COLLISION) {
//        
//            for (int i = 0; i < mobs.size(); i++) {
//
//                Monsters bag = (Monsters) mobs.get(i);
//                if (karakter.isBottomCollision(bag)) {
//                    for (int j = 0; j < mobs.size(); j++) {
//
//                        Monsters item = (Monsters) mobs.get(j);
//                        if (!bag.equals(item)) {
//                            if (bag.isBottomCollision(item)) {
//                                return true;
//                            }
//                        }
//                        if (checkWallCollision(bag,
//                                BOTTOM_COLLISION)) {
//                            return true;
//                        }
//                    }
//                    bag.move(0, SPACE);
//                }
//            }
//        }
//
//        return false;
//    }
//

//    public void restartLevel() {
//
//        areas.clear();
//        mobs.clear();
//        walls.clear();
//        initWorld();
//        if (completed) {
//            completed = false;
//        }
//    }
}

