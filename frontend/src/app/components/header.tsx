import styles from "src/app/styles/header.module.css"
import Navigation from "./navigation"
import Logo from "./logo"

export default function Header(){
  return (
    <header className={styles.headerWrapper}>
      <div className={styles.headerInner}>

      <Logo />
      <Navigation />
      </div>
    </header>
  )
}