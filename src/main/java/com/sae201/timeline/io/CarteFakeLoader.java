package com.sae201.timeline.io;

import com.sae201.timeline.model.Carte;

public class CarteFakeLoader extends CarteLoader {
    @Override
    public void load() {
    	setTitre("Systèmes d'exploitation");

        ajouterCarte(new Carte("Unix", "1969", 1,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/UNIX_logo.svg/langfr-1920px-UNIX_logo.svg.png"));

        ajouterCarte(new Carte("CP/M", "1974", 2,
            "https://upload.wikimedia.org/wikipedia/commons/7/7e/Logo_CPM.png"));

        ajouterCarte(new Carte("Apple DOS", "1978", 3,
            "https://upload.wikimedia.org/wikipedia/commons/f/fa/Apple_logo_black.svg"));

        ajouterCarte(new Carte("MS-DOS", "1981", 4,
            "https://upload.wikimedia.org/wikipedia/commons/3/3d/Msdos-icon.png"));

        ajouterCarte(new Carte("Macintosh System Software", "1984", 5,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2t8On41yKcUIdPUS_xlRABGC9RTvc31z9GQ&s"));

        ajouterCarte(new Carte("AmigaOS", "1985", 6,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTWQiAWz44rGZlR4Nk2wMhFjmubH2gr5W5OHw&s"));

        ajouterCarte(new Carte("Windows 1.0", "1985", 7,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Windows_logo_-_1985-1989.svg/2560px-Windows_logo_-_1985-1989.svg.png"));

        ajouterCarte(new Carte("OS/2", "1987", 8,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Os2logo.svg/1200px-Os2logo.svg.png"));

        ajouterCarte(new Carte("Windows 95", "1995", 9,
            "https://upload.wikimedia.org/wikipedia/commons/6/6d/Windows_Logo_%281992-2001%29.svg"));

        ajouterCarte(new Carte("BeOS", "1995", 10,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/BeOS_logo.svg/1200px-BeOS_logo.svg.png"));

        ajouterCarte(new Carte("Windows XP", "2001", 11,
            "https://cdn.worldvectorlogo.com/logos/microsoft-windows-xp-professional-1.svg"));

        ajouterCarte(new Carte("Mac OS X", "2001", 12,
            "https://1000logos.net/wp-content/uploads/2024/01/macOS-X-Logo-2001.png"));

        ajouterCarte(new Carte("Arch Linux", "2002", 13,
            "https://img.icons8.com/color/512/arch-linux.png"));

        ajouterCarte(new Carte("Ubuntu", "2004", 14,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQhUXYtZGaSVpgszvcdic5jZKt2rhQZqPGEng&s"));

        ajouterCarte(new Carte("Android", "2008", 15,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Android_logo_2019_%28stacked%29.svg/2346px-Android_logo_2019_%28stacked%29.svg.png"));

        ajouterCarte(new Carte("ChromeOS", "2009", 16,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Google_Chrome_icon_%28February_2022%29.svg/2048px-Google_Chrome_icon_%28February_2022%29.svg.png"));

        ajouterCarte(new Carte("Windows 10", "2015", 17,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Windows_logo_-_2012_%28dark_blue%29.svg/480px-Windows_logo_-_2012_%28dark_blue%29.svg.png"));

        ajouterCarte(new Carte("elementary OS", "2011", 18,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_UR9rKfnNisRhbECbaKPoEnmGuaFuJpaUlg&s"));

        ajouterCarte(new Carte("Pop!_OS", "2017", 19,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Pop%21_OS_Icon.svg/2048px-Pop%21_OS_Icon.svg.png"));

        ajouterCarte(new Carte("Windows 11", "2021", 20,
            "https://img.icons8.com/?size=512&id=M9BRw0RJZXKi&format=png"));
    }
}