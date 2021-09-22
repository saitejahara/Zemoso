import { Typography } from "@material-ui/core";
import { useState, useEffect } from "react";
import { makeStyles, createStyles, Theme } from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import BookCard from "../../molecules/BookCard/BookCard";
import "../MyLibraryContent/MyLibraryContent.css";
import SearchIcon from "@material-ui/icons/Search";
import { useAuth0 } from "@auth0/auth0-react";

import InputFieldComponent from "../../atoms/InputField/InputField";
import IconButton from "../../atoms/IconButton/IconButton";

const useStyles = makeStyles((theme: Theme) =>
  createStyles({
    divgrid: {
      display: "flex",
      justifyContent: "center",
      alignItems: "center",
    },
  })
);

type bookreturn = {
  id: 5;
  title: "Exercised";
  author: "Daniel E. Lieberman";
  time: "13";
  category: "Science";
  image: "https://images.blinkist.com/images/books/60507e296cee070007c4dc7e/1_1/470.jpg";
  status: string;
};

const Explore = (props: any) => {
  const { isAuthenticated } = useAuth0();

  const classes = useStyles();
  const [status, setStatus] = useState("explore");
  const [books, setBooks] = useState<bookreturn[]>([]);

  useEffect(() => {
    fetch("http://localhost:8000/books")
      .then((result) => result.json())
      .then((books) => setBooks(books));
  }, [books]);

  const handleLibrary = async (bookId: number) => {
    console.log("handle library book");
    console.log(bookId);
    var tempBook: bookreturn;
    await fetch("http://localhost:8000/books/" + bookId)
      .then((result) => {
        return result.json();
      })
      .then((data) => {
        tempBook = data;
      });
    const arr = ["explore", "current"];

    let i = arr.indexOf(tempBook!.status);
    tempBook!.status = arr[i + 1];
    console.log(tempBook!);
    await fetch("http://localhost:8000/books/" + bookId, {
      method: "PUT",
      body: JSON.stringify(tempBook!),
      headers: {
        "Content-type": "application/json; charset=UTF-8",
      },
    });
  };

  //search bar
  const [filter, setFilter] = useState("");

  const searchText = (event: any) => {
    setFilter(event.target.value);
  };
  let dataSearch = books.filter((item) => {
    return Object.keys(item).some((key) =>
      item.title
        .toString()
        .toLowerCase()
        .includes(filter.toString().toLowerCase())
    );
  });

  return (
    <div>
      <Typography variant="h2">Explore</Typography>

      <br />
      <br />
      <div className="col-12 mb-5">
        <div className="mb-3 col-4 mx-auto">
          <IconButton
            color="primary"
            disabled={true}
            icon={<SearchIcon fontSize="medium" />}
          ></IconButton>
          <label className="form-label h5">Search</label>

          <InputFieldComponent
            type="text"
            className="form-control"
            value={filter}
            onChange={searchText.bind(this)}
          />
        </div>
      </div>
      <div className="container">
        <div className="content-tabs">
          <div>
            <Grid
              className={classes.divgrid}
              container
              item
              xs={12}
              spacing={1}
            >
              {books.map((book) => (
                <Grid key={book.id} item xs={3} md={4}>
                  <BookCard
                    key={2}
                    image={book.image}
                    name="Add to Library"
                    title={book.title}
                    author={book.author}
                    time={book.time}
                    //disabled={false}
                    id={book.id}
                    onClick={() => handleLibrary(book.id)}
                    disabled={
                      isAuthenticated
                        ? book.status !== "explore"
                          ? true
                          : false
                        : true
                    }
                  ></BookCard>
                </Grid>
              ))}
            </Grid>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Explore;
