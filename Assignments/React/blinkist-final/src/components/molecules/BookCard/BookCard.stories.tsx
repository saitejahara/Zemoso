import BookCard from "./BookCard";
import logo from "../../../assets/images/Blinkist_logo2.png";

export default {
  title: "BookCard",
  component: BookCard,
};

export const BookCardType1 = () => (
  <BookCard
    image={logo}
    name="Read Again"
    title="Book1"
    author="author1"
    time={12}
    disabled={false}
    set={true}
    onClick={() => console.log("BookCard clicked")}
  ></BookCard>
);
