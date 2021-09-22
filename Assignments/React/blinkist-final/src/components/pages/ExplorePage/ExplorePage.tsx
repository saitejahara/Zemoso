import React from "react";
import Explore from "../../organisms/ExploreContent/ExploreContent";
import Header from "../../organisms/Header/Header";
// import MyLibrary from "../../organisms/MyLibraryContent/MyLibraryContent";
import baseTheme from "../../theme";
import CommonTemplate from "../../templates/CommonTemplate/CommonTemplate";
import { ThemeProvider } from "@material-ui/styles";

const ExplorePage = () => {
  return (
    <ThemeProvider theme={baseTheme}>
      <CommonTemplate
        header={<Header />}
        // pageName="Explore"
        mainContent={<Explore />}
      />
    </ThemeProvider>
  );
};

export default ExplorePage;
