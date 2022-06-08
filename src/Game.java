import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * The type Game.
 */
public class Game extends Canvas implements Runnable
{
    private boolean isRunning = false ;
    private Thread thread;
    private final Handler handler ;
    private final Handler handler1 ;
    private final Handler handler2 ;
    private final Handler handler3 ;
    private final Camera camera ;
    private SpriteSheet ss;
    private final BufferedImage map ;
    /**
     * Instantiates a new Game.
     */
    public Game()
    {
        new Window(800,600,"Goalkeeper game",this);
        handler = new Handler();
        handler1 = new Handler();
        handler2 = new Handler();
        handler3 = new Handler();
        camera = new Camera(0,0);
        this.addKeyListener(new KeyInput(handler,this,ss,camera));
        this.addKeyListener(new KeyInput(handler1,this,ss,camera));
        this.addKeyListener(new KeyInput(handler2,this,ss,camera));
        this.addKeyListener(new KeyInput(handler3,this,ss,camera));
        BufferedImageLoader loader = new BufferedImageLoader();
        BufferedImage level = loader.loadImage("/game_level.png");
        BufferedImage sprite_sheet = loader.loadImage("/player_images.png");
        
        ss =new SpriteSheet(sprite_sheet);
        map= ss.grabImage(4, 2, 32, 32);
        
        this.addMouseListener(new MouseInput(handler , camera , ss,this));
        this.addMouseListener(new MouseInput(handler1 , camera , ss,this));
        this.addMouseListener(new MouseInput(handler2 , camera , ss,this));
        this.addMouseListener(new MouseInput(handler3 , camera , ss,this));
       
      loadLevel(level);
    }
    private void start()
    {
        isRunning=true;
        thread = new Thread(this);
        thread.start();
    }
    private void stop()
    {
        isRunning = false;

        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run() 
    {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 120.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0 ;
        long timer = System.currentTimeMillis();
        while(isRunning)
        {
            long now = System.nanoTime();
            delta+= (now - lastTime) / ns ;
            lastTime = now ; 
            while(delta>= 1 )
            {
                tick();
                delta--;
            }
            render();
            if (System.currentTimeMillis() - timer >1000)
            {
                timer+=1000;
            }
        }
        stop();
    }

    /**
     * Tick.
     */
    // updating the game frames
    public void tick ()
        {
            for(int i = 0 ; i < handler.object.size(); i++ ) {
                if(handler.object.get(i).getId() == Elements.Player)
                {
                    camera.tick(handler.object.get(i));
                }

            }
            for (int i = 0; i < handler1.object.size(); i++) {
                if(handler1.object.get(i).getId() == Elements.Player1)
                {
                    camera.tick(handler1.object.get(i));
                }
            }
            for (int i = 0; i < handler2.object.size(); i++) {
                if(handler2.object.get(i).getId() == Elements.Player2)
                {
                    camera.tick(handler2.object.get(i));
                }
            }
            for (int i = 0; i < handler3.object.size(); i++) {
                if(handler3.object.get(i).getId() == Elements.Player3)
                {
                    camera.tick(handler3.object.get(i));
                }
            }
            handler.tick();
            handler1.tick();
            handler2.tick();
            handler3.tick();
        }

    /**
     * Render.
     */
    public void render()
        {

            //pre loading the frames like loading 3 frames before rendering if we increase it won't matter cause
            // we can't notice anything after 3
            BufferStrategy bs = this.getBufferStrategy();
            if (bs == null)
            {
                this.createBufferStrategy(3);
                return;
            }
            Graphics g = bs.getDrawGraphics();
            Graphics2D g2d = (Graphics2D) g;
            //////////////////////////////////////
            g2d.translate(-camera.getX() , -camera.getY());
            
            for(int xx = 0 ; xx<32*100 ; xx+=32 )
            {
                for(int yy= 0 ; yy<32*100; yy+=32)
                {
                    g.drawImage(map, xx, yy, null);
                }
            }
           // to render them above the map
            handler.render(g);
            handler1.render(g);
            handler2.render(g);
            handler3.render(g);
            
              g2d.translate(camera.getX() , camera.getY());
               g.setColor(Color.green);
                g.setColor(Color.white);
                g.drawString("Balls Blocked  :"+ GoalKeeper.balls_blocked ,10,70);
                g.setColor(Color.white);
                g.setColor(Color.white);
                g.setColor(Color.white);
            /////////////////////////////////////
            g.dispose();
            bs.show();
             
        }
        private void loadLevel(BufferedImage image )
        {
            int w = image.getWidth();
            int h = image.getHeight();
            for(int xx =0 ; xx < w ; xx++)
            {
                for(int yy=0 ; yy < h ; yy++)
                {
                    int pixel = image.getRGB(xx, yy);
                  
                    int red = (pixel >> 16 )& 0xff;
                    int green = (pixel>>8) & 0xff;
                    int blue = (pixel )& 0xff;
                    if (red == 255)
                        handler.addObject(new Block(xx*32 , yy*32 , Elements.Block,ss));
                    if(blue == 255) {
                        handler.addObject(new Shooter(xx * 32, yy * 32, Elements.Player, handler, ss));
                        handler1.addObject(new Shooter(xx*34 ,yy*34 , Elements.Player1,handler1,ss));
                        handler2.addObject(new Shooter(xx*36 ,yy*36 , Elements.Player2,handler2,ss));
                        handler3.addObject(new Shooter(xx*38 ,yy*38 , Elements.Player3,handler3,ss));
                    }
                    if(green ==255)
                        handler.addObject(new GoalKeeper(xx*32 , yy*32 , Elements.Enemy , handler,ss, this));
                }
            }
        }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        Game t = new Game();
        t.start();
    }
}

