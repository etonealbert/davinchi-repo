# Ni Tan Biónica, Ni Tan Bizarrap - Album Promotion Website

## 🎵 Project Overview
A modern, responsive website promoting the fictional collaboration album between Tan Biónica and Bizarrap, blending pop-rock and electronic/trap aesthetics.

## 🏗️ Architecture & File Structure

```
/
├── index.html                 # Landing page (Inicio)
├── about.html                # Artist information (Sobre el Artista)
├── album.html                # Album details & tracklist (El Álbum)
├── limited-edition.html      # Limited edition details (Edición Limitada)
├── contact.html              # Contact & pre-order (Contacto/Preventa)
├── README.md                 # Project documentation
├── assets/
│   ├── css/
│   │   ├── styles.css        # Main stylesheet
│   │   ├── animations.css    # CSS animations & effects
│   │   └── responsive.css    # Media queries & responsive design
│   ├── images/
│   │   ├── album/           # Album-related images
│   │   ├── artists/         # Artist photos & bios
│   │   ├── limited-edition/ # Limited edition product images
│   │   ├── backgrounds/     # Background images & textures
│   │   └── icons/          # UI icons & small graphics
│   ├── fonts/              # Local font files (fallback)
│   └── audio/              # Audio preview files (optional)
└── components/             # Reusable CSS components
    ├── header.css          # Navigation styling
    ├── footer.css          # Footer styling
    ├── buttons.css         # Button components
    └── cards.css           # Card components
```

## 🎨 Design System

### Color Palette
- **Primary Purple**: #A100A1 (Neon Purple)
- **Electric Blue**: #00D4FF 
- **Deep Black**: #1A1A1A
- **Dark Gray**: #2A2A2A
- **White**: #FFFFFF
- **Silver**: #C0C0C0

### Typography
- **Headers**: Montserrat (Google Fonts) - Bold, modern
- **Subheaders**: Bebas Neue (Google Fonts) - Display font
- **Body Text**: Roboto (Google Fonts) - Clean, readable
- **Accent**: Open Sans (Google Fonts) - Secondary text

### Breakpoints
- **Desktop**: 1200px+
- **Tablet**: 768px - 1199px
- **Mobile**: 320px - 767px

## 📸 Required Images

### You need to add these images to the specified folders:

#### `/assets/images/album/`
1. **album-cover.jpg** (800x800px) - Main album cover
2. **album-cover-animated.gif** (800x800px) - Animated version for hero section
3. **vinyl-mockup.jpg** (600x600px) - Vinyl record image
4. **cd-mockup.jpg** (500x500px) - CD version mockup

#### `/assets/images/artists/`
1. **tan-bionica-band.jpg** (800x600px) - Band group photo
2. **chano-portrait.jpg** (400x600px) - Chano solo portrait
3. **bizarrap-portrait.jpg** (400x600px) - Bizarrap portrait
4. **collaboration-photo.jpg** (1200x800px) - Both artists together

#### `/assets/images/limited-edition/`
1. **vinyl-colors.jpg** (600x400px) - Neon purple & electric blue vinyl
2. **booklet-pages.jpg** (800x600px) - 24-page booklet spread
3. **tshirt-mockup.jpg** (500x600px) - Album logo t-shirt
4. **stickers-holographic.jpg** (400x300px) - Holographic stickers
5. **signed-poster.jpg** (600x800px) - Limited signed poster
6. **package-complete.jpg** (800x800px) - Complete limited edition package

#### `/assets/images/backgrounds/`
1. **hero-background.jpg** (1920x1080px) - Buenos Aires nightlife scene
2. **neon-abstract.jpg** (1600x900px) - Abstract neon pattern
3. **city-lights-blur.jpg** (1920x1080px) - Blurred city lights
4. **glitch-texture.png** (500x500px) - Glitch effect overlay
5. **gradient-mesh.jpg** (1200x800px) - Purple-blue gradient mesh

#### `/assets/images/icons/`
1. **play-icon.svg** - Audio player play button
2. **pause-icon.svg** - Audio player pause button
3. **social-icons.svg** - Instagram, Spotify, YouTube icons
4. **arrow-down.svg** - Scroll indicator
5. **menu-burger.svg** - Mobile menu icon

## 🚀 Features

### Core Functionality
- ✅ Responsive design (mobile-first approach)
- ✅ Semantic HTML5 structure
- ✅ CSS Grid & Flexbox layouts
- ✅ Smooth CSS animations
- ✅ Interactive album cover
- ✅ Custom typography integration
- ✅ Cross-browser compatibility

### Interactive Elements
- ✅ Animated album cover (hover effects, glitch animations)
- ✅ Smooth scroll navigation
- ✅ Hover effects on buttons and cards
- ✅ Mobile-friendly navigation
- ✅ Form validation (contact page)
- ✅ Audio player interface (optional)

### Performance Optimizations
- ✅ Optimized images (WebP with fallbacks)
- ✅ CSS minification ready
- ✅ Lazy loading preparation
- ✅ Mobile-first CSS approach

## 🛠️ Technical Implementation

### CSS Architecture
- **Modular CSS**: Separate files for components
- **BEM Methodology**: Block-Element-Modifier naming
- **CSS Custom Properties**: For theme consistency
- **Progressive Enhancement**: Core functionality first

### Browser Support
- Chrome 80+
- Firefox 75+
- Safari 13+
- Edge 80+

## 📝 Development Notes

### Image Optimization Tips
- Use WebP format for better compression
- Optimize for web (max 200KB per image)
- Provide multiple sizes for responsive images
- Use TinyPNG for compression

### Performance Best Practices
- Lazy load images below the fold
- Use CSS transforms for animations (GPU acceleration)
- Minimize HTTP requests
- Compress CSS and optimize font loading

## 🎯 SEO & Accessibility

### SEO Elements
- Semantic HTML structure
- Meta tags for social sharing
- Alt text for all images
- Structured data markup

### Accessibility Features
- WCAG 2.1 AA compliance
- Keyboard navigation support
- Screen reader compatibility
- High contrast color ratios

## 📱 Testing Checklist

### Responsiveness
- [ ] Desktop (1920px, 1366px, 1200px)
- [ ] Tablet (1024px, 768px)
- [ ] Mobile (414px, 375px, 320px)

### Browsers
- [ ] Chrome
- [ ] Firefox
- [ ] Safari
- [ ] Edge

### Performance
- [ ] Page load speed < 3s
- [ ] Images optimized
- [ ] CSS minified
- [ ] No console errors

---

**Created by**: Senior Frontend Developer
**Technologies**: HTML5, CSS3, Google Fonts
**Aesthetic**: Pop-rock meets Electronic/Trap
**Theme**: Buenos Aires Nightlife + Modern Electronic Vibes 