--
-- Table `member`
--

INSERT INTO `member` (`id`, `login`, `password`, `email`, `phoneNumber`, `address`, `postalCode`, `town`, `isAdmin`) VALUES
(9, 'azertyuiop', '7682fe272099ea26efe39c890b33675b', 'test@example.com', '0102030405', '7 Cité Paradis', 75000, 'Paris', 1),
(10, 'Dynofoot', '5be977ac2dc6c7c07f8825de5f3c9926', 'dynofoot@gmail.com', '', '3 rue des couloirs', 63000, 'Clermont-Ferrand', 0),
(11, 'Robot', '098f6bcd4621d373cade4e832627b4f6', 'test@gmail.com', '', 'Rue du test', 75000, 'Paris', 0);

--
-- Table `site`
--

INSERT INTO `site` (`id`, `name`, `description`, `sectors`, `numberOfSectors`, `length`, `place`, `grade`, `numberOfWays`, `isOfficial`) VALUES
(1, 'Cantobre', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin mattis facilisis ante non varius. Phasellus fringilla vehicula interdum. Suspendisse vestibulum dui orci, ut hendrerit nunc aliquet sit amet. Morbi non imperdiet dolor, at tincidunt lacus. Aenean metus massa, lobortis lacinia augue ac, dictum mollis libero. Pellentesque eget justo vel quam pellentesque tincidunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'Barre Principale, Jo Barre Team', 2, 40, 'France - Aveyron', '5c à 9a', 55, 0),
(2, 'Arudy', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin mattis facilisis ante non varius. Phasellus fringilla vehicula interdum. Suspendisse vestibulum dui orci, ut hendrerit nunc aliquet sit amet. Morbi non imperdiet dolor, at tincidunt lacus. Aenean metus massa, lobortis lacinia augue ac, dictum mollis libero. Pellentesque eget justo vel quam pellentesque tincidunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'Sesto, Malaraude, Houn de Laa, Sirène, Vénus, Gaufrette, La Fonderie, Soleil', 8, 55, 'France - Pyrénées Atlantiques', '3c à 8b', 230, 1),
(3, 'Rurey', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin mattis facilisis ante non varius. Phasellus fringilla vehicula interdum. Suspendisse vestibulum dui orci, ut hendrerit nunc aliquet sit amet. Morbi non imperdiet dolor, at tincidunt lacus. Aenean metus massa, lobortis lacinia augue ac, dictum mollis libero. Pellentesque eget justo vel quam pellentesque tincidunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'Euphorie, Rureyssim, High Voltage', 3, 30, 'France-Doubs', '4c à 8c', 100, 1),
(4, 'Cantobre', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin mattis facilisis ante non varius. Phasellus fringilla vehicula interdum. Suspendisse vestibulum dui orci, ut hendrerit nunc aliquet sit amet. Morbi non imperdiet dolor, at tincidunt lacus. Aenean metus massa, lobortis lacinia augue ac, dictum mollis libero. Pellentesque eget justo vel quam pellentesque tincidunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'Barre Principale, Jo Barre Team', 2, 40, 'France - Aveyron', '5c à 9a', 55, 0),
(5, 'Arudy', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin mattis facilisis ante non varius. Phasellus fringilla vehicula interdum. Suspendisse vestibulum dui orci, ut hendrerit nunc aliquet sit amet. Morbi non imperdiet dolor, at tincidunt lacus. Aenean metus massa, lobortis lacinia augue ac, dictum mollis libero. Pellentesque eget justo vel quam pellentesque tincidunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'Sesto, Malaraude, Houn de Laa, Sirène, Vénus, Gaufrette, La Fonderie, Soleil', 8, 55, 'France - Pyrénées Atlantiques', '3c à 8b', 230, 0),
(6, 'Rurey', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin mattis facilisis ante non varius. Phasellus fringilla vehicula interdum. Suspendisse vestibulum dui orci, ut hendrerit nunc aliquet sit amet. Morbi non imperdiet dolor, at tincidunt lacus. Aenean metus massa, lobortis lacinia augue ac, dictum mollis libero. Pellentesque eget justo vel quam pellentesque tincidunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'Euphorie, Rureyssim, High Voltage', 3, 30, 'France-Doubs', '4c à 8c', 100, 0),
(7, 'Cantobre', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin mattis facilisis ante non varius. Phasellus fringilla vehicula interdum. Suspendisse vestibulum dui orci, ut hendrerit nunc aliquet sit amet. Morbi non imperdiet dolor, at tincidunt lacus. Aenean metus massa, lobortis lacinia augue ac, dictum mollis libero. Pellentesque eget justo vel quam pellentesque tincidunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'Barre Principale, Jo Barre Team', 2, 40, 'France - Aveyron', '5c à 9a', 55, 0),
(8, 'Arudy', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin mattis facilisis ante non varius. Phasellus fringilla vehicula interdum. Suspendisse vestibulum dui orci, ut hendrerit nunc aliquet sit amet. Morbi non imperdiet dolor, at tincidunt lacus. Aenean metus massa, lobortis lacinia augue ac, dictum mollis libero. Pellentesque eget justo vel quam pellentesque tincidunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'Sesto, Malaraude, Houn de Laa, Sirène, Vénus, Gaufrette, La Fonderie, Soleil', 8, 55, 'France - Pyrénées Atlantiques', '3c à 8b', 230, 0),
(9, 'Rurey', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin mattis facilisis ante non varius. Phasellus fringilla vehicula interdum. Suspendisse vestibulum dui orci, ut hendrerit nunc aliquet sit amet. Morbi non imperdiet dolor, at tincidunt lacus. Aenean metus massa, lobortis lacinia augue ac, dictum mollis libero. Pellentesque eget justo vel quam pellentesque tincidunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'Euphorie, Rureyssim, High Voltage', 3, 30, 'France-Doubs', '4c à 8c', 100, 0),
(10, 'Test', 'Ceci est un test', 'Montée, Sommet, , , ', 2, 50, 'Falaises', '4a', 18, 1);

--
-- Table `comment`
--

INSERT INTO `comment` (`id`, `author`, `comment`, `siteId`) VALUES
(11, 'Dynofoot', 'Bonjour tout le monde !', 1);

--
-- Table `topo`
--

INSERT INTO `topo` (`id`, `name`, `description`, `place`, `date`, `memberId`, `isAvailable`, `isAwaiting`, `isReserved`) VALUES
(20, 'Topo de test', 'Ce topo est conçu pour tester le site web !', 'Falaises', '2019-12-10', 10, 1, 0, 0),
(21, 'Topo d\'Auvergne', 'Un topo de l\'Auvergne.', 'Auvergne', '2019-12-10', 10, 0, 0, 0);
